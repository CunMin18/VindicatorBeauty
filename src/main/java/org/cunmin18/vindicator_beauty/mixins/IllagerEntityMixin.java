package org.cunmin18.vindicator_beauty.mixins;

import net.minecraft.entity.mob.IllagerEntity;
import org.cunmin18.vindicator_beauty.goals.IllagerBreedGoal;
import org.cunmin18.vindicator_beauty.utils.IMobEntityMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(IllagerEntity.class)
public class IllagerEntityMixin{
    @Inject(method = "initGoals",at = @At("TAIL"))
    protected void initGoals(CallbackInfo ci){
        var illager = (IllagerEntity) (Object)this;
        var targetSelector = ((IMobEntityMixin) illager).getTargetSelector();
        var goalSelector = ((IMobEntityMixin) illager).getGoalSelector();
        goalSelector.add(1,new IllagerBreedGoal(illager,false));
    }
}
