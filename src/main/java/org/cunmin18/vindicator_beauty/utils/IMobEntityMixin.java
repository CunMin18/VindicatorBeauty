package org.cunmin18.vindicator_beauty.utils;

import net.minecraft.entity.ai.goal.GoalSelector;

public interface IMobEntityMixin {
    GoalSelector getGoalSelector();
    GoalSelector getTargetSelector();
}
