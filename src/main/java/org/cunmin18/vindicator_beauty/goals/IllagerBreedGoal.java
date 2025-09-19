package org.cunmin18.vindicator_beauty.goals;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.brain.task.LookTargetUtil;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.cunmin18.vindicator_beauty.entities.ModEntities;
import org.cunmin18.vindicator_beauty.entities.VindicatorBeautyEntity;

import java.util.Optional;

public class IllagerBreedGoal extends Goal {
    private final IllagerEntity self;
    private final World world;
    private IllagerEntity target;
    private int cooldown = 0;
    private boolean beautySelf = false;

    public IllagerBreedGoal(IllagerEntity illagerEntity,boolean beautySelf) {
        this.self = illagerEntity;
        this.target = null;
        this.beautySelf = beautySelf;
        this.world = illagerEntity.getWorld();
    }
    @Override
    public boolean canStart() {
        return self.isOnGround() && !self.isBaby() && !self.hasStatusEffect(StatusEffects.WITHER);
    }

    @Override
    public void start() {
        this.target = beautySelf ? findAnIllager() : findAVindicatorBeauty();
        if (target != null) {
            cooldown = 60; // 设置初始冷却时间
            // 发送爱心粒子效果
            if (!world.isClient) {
                ((ServerWorld)world).sendEntityStatus(self, (byte)18);
                ((ServerWorld)world).sendEntityStatus(target, (byte)18);
            }
        }
    }

    @Override
    public void stop() {
        this.target = null;
        cooldown = 0;
    }

    @Override
    public boolean shouldContinue() {
        return target != null && target.isAlive() && !target.isBaby() && !self.isBaby();
    }

    @Override
    public void tick() {
        if(!canStart()) {
            stop();
            return;
        }

        if (target == null || !target.isAlive()) {
            return;
        }

        // 计算距离
        double distanceSq = self.squaredDistanceTo(target);

        // 让两个实体互相看向对方
        self.getLookControl().lookAt(target, 10.0F, self.getMaxLookPitchChange());
        target.getLookControl().lookAt(self, 10.0F, target.getMaxLookPitchChange());

        // 根据距离调整移动速度
        if (distanceSq > 4.0) { // 2格以外
            // 慢慢靠近
            self.getNavigation().startMovingTo(target, 0.8F);
            if (target instanceof MobEntity) {
                ((MobEntity)target).getNavigation().startMovingTo(self, 0.8F);
            }
        } else if (distanceSq > 1.0) { // 1-2格之间
            // 减速靠近
            self.getNavigation().startMovingTo(target, 0.3F);
            if (target instanceof MobEntity) {
                ((MobEntity)target).getNavigation().startMovingTo(self, 0.3F);
            }
        } else {
            // 面对面停止
            self.getNavigation().stop();
            if (target instanceof MobEntity) {
                ((MobEntity)target).getNavigation().stop();
            }
        }

        // 定期发送爱心粒子效果
        if (world.getTime() % 20 == 0 && !world.isClient) {
            double headX = self.getX();
            double headY = self.getY() + self.getHeight() * 0.8;
            double headZ = self.getZ();
            if (!world.isClient) {
                ((ServerWorld)world).spawnParticles(
                        ParticleTypes.HEART,
                        headX + (world.random.nextDouble() - 0.5) * 0.5,
                        headY + world.random.nextDouble() * 0.5,
                        headZ + (world.random.nextDouble() - 0.5) * 0.5,
                        3,
                        0, 0, 0,
                        0.0
                );
            }
        }

        if (distanceSq <= 3.0) {
            if (cooldown <= 0) {
                // 繁殖前发送更多爱心效果
                double headX = self.getX();
                double headY = self.getY() + self.getHeight() * 0.8;
                double headZ = self.getZ();
                if (!world.isClient) {
                    ((ServerWorld)world).spawnParticles(
                            ParticleTypes.HEART,
                            headX + (world.random.nextDouble() - 0.5) * 0.5,
                            headY + world.random.nextDouble() * 0.5,
                            headZ + (world.random.nextDouble() - 0.5) * 0.5,
                            5,
                            0, 0, 0,
                            0.0
                    );
                }
                createChild();
                cooldown = 200;
                stop();
            } else {
                cooldown--;
            }
        }
    }
    private Optional<VindicatorBeautyEntity> createChild() {
        VindicatorBeautyEntity baby = new VindicatorBeautyEntity(ModEntities.VINDICATOR_BEAUTY_ENTITY_TYPE, world);

        //传播疾病
        if(!(self instanceof VindicatorBeautyEntity)) makeTargetSick(self);
        if(!(target instanceof VindicatorBeautyEntity)) makeTargetSick(target);

        // 设置孩子的位置在父母之间
        double x = (self.getX() + target.getX()) / 2.0;
        double y = self.getY();
        double z = (self.getZ() + target.getZ()) / 2.0;

        baby.refreshPositionAndAngles(x, y, z, 0.0f, 0.0f);

        baby.initialize((ServerWorld)world, world.getLocalDifficulty(baby.getBlockPos()), SpawnReason.BREEDING, (EntityData)null, (NbtCompound)null);

        // 添加到世界
        ((ServerWorld)world).spawnEntityAndPassengers(baby);
        world.sendEntityStatus(baby, (byte)12);
        baby.setBaby(true);
        return Optional.of(baby);
    }
    private void makeTargetSick(IllagerEntity target){
        StatusEffectInstance weakness = new StatusEffectInstance(
                StatusEffects.WEAKNESS,
                72000,
                100,
                false,
                false,
                false
        );
        StatusEffectInstance wither = new StatusEffectInstance(
                StatusEffects.WITHER,
                72000,
                2,
                false,
                false,
                false
        );
        target.addStatusEffect(weakness);
        target.addStatusEffect(wither);
    }
    //寻找一只美女
    private VindicatorBeautyEntity findAVindicatorBeauty(){
        var minWorldPos = self.getBlockPos().add(-100, -50, -100);
        var maxWorldPos = self.getBlockPos().add(100, 50, 100);
        Vec3d vec1 = new Vec3d(minWorldPos.getX(), minWorldPos.getY(), minWorldPos.getZ());
        Vec3d vec2 = new Vec3d(maxWorldPos.getX(), maxWorldPos.getY(), maxWorldPos.getZ());
        var targets = world.getEntitiesByClass(VindicatorBeautyEntity.class, new Box(vec1, vec2), entity -> entity.canBreed());
        if(targets.isEmpty()) return null;
        return targets.get(0);
    }
    //寻找一个灾厄村民
    private IllagerEntity findAnIllager(){
        var minWorldPos = self.getBlockPos().add(-100, -50, -100);
        var maxWorldPos = self.getBlockPos().add(100, 50, 100);
        Vec3d vec1 = new Vec3d(minWorldPos.getX(), minWorldPos.getY(), minWorldPos.getZ());
        Vec3d vec2 = new Vec3d(maxWorldPos.getX(), maxWorldPos.getY(), maxWorldPos.getZ());
        var targets = world.getEntitiesByClass(IllagerEntity.class, new Box(vec1, vec2), entity -> !(entity instanceof VindicatorBeautyEntity) && !(entity.hasStatusEffect(StatusEffects.WITHER)));
        if(targets.isEmpty()) return null;
        return targets.get(0);
    }
}
