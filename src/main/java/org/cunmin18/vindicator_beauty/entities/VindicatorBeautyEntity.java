package org.cunmin18.vindicator_beauty.entities;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.cunmin18.vindicator_beauty.goals.IllagerBreedGoal;


public class VindicatorBeautyEntity extends IllagerEntity{
    private static final TrackedData<Boolean> WALKING = DataTracker.registerData(VindicatorBeautyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> IS_BABY = DataTracker.registerData(VindicatorBeautyEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout;
    private int lifeTicks;

    public VindicatorBeautyEntity(EntityType<? extends IllagerEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, (double)20.0F).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, (double)0.25F);
    }
    private void setupAnimationStates() {
        if(this.isMoving() && walkAnimationTimeout <= 0) {
            walkAnimationTimeout = 40;
            walkAnimationState.start(this.age);
        } else {
            --this.walkAnimationTimeout;
        }

        if(!this.isAttacking()) {
            walkAnimationState.stop();
        }
    }
    @Override
    public void move(MovementType movementType, Vec3d movement) {
        super.move(movementType, movement);
        setMoving(true);
    }
    public void setMoving(boolean moving) {
        this.dataTracker.set(WALKING, moving);
    }

    public boolean isMoving() {
        return this.dataTracker.get(WALKING);
    }

    public boolean isBaby() {
        return this.dataTracker.get(IS_BABY);
    }
    public void setBaby(boolean isBaby){
        this.dataTracker.set(IS_BABY,isBaby);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(WALKING, false);
        this.dataTracker.startTracking(IS_BABY,false);
    }


    @Override
    public void addBonusForWave(int wave, boolean unused) {
    }

    @Override
    public SoundEvent getCelebratingSound() {
        return null;
    }

    @Override
    public void tick() {
        super.tick();

        //逐渐长大
        lifeTicks++;
        if(lifeTicks >= 1200 && isBaby()){
            setBaby(false);
        }

        if(this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new IllagerBreedGoal(this, true));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, IllagerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(2, new RevengeGoal(this));
    }


    public boolean canBreed() {
        return !this.isBaby();
    }
}
