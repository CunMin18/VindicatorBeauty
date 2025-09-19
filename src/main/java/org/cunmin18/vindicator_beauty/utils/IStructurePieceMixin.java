package org.cunmin18.vindicator_beauty.utils;

import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.StructureWorldAccess;
import org.jetbrains.annotations.Nullable;

public interface IStructurePieceMixin {
    boolean callAddChest(ServerWorldAccess world, BlockBox boundingBox, Random random, BlockPos pos, Identifier lootTableId, @Nullable BlockState block);
}
