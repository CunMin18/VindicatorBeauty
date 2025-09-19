package org.cunmin18.vindicator_beauty.mixins;

import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import org.cunmin18.vindicator_beauty.utils.IMobEntityMixin;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin implements IMobEntityMixin {
    @Shadow
    @Final
    protected GoalSelector goalSelector;
    @Shadow
    @Final
    protected GoalSelector targetSelector;

    @Override
    @Unique
    public GoalSelector getGoalSelector() {
        return goalSelector;
    }

    @Override
    @Unique
    public GoalSelector getTargetSelector() {
        return targetSelector;
    }
}
