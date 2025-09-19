package org.cunmin18.vindicator_beauty.mixins;

import net.minecraft.block.BlockState;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.cunmin18.vindicator_beauty.utils.IStructurePieceMixin;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(StructurePiece.class)
public abstract class StructurePieceMixin implements IStructurePieceMixin {
    @Shadow
    protected abstract boolean addChest(ServerWorldAccess world, BlockBox boundingBox, Random random, BlockPos pos, Identifier lootTableId, @Nullable BlockState block);
    @Unique
    public boolean callAddChest(ServerWorldAccess world, BlockBox boundingBox, Random random, BlockPos pos, Identifier lootTableId, @Nullable BlockState block){
        return addChest(world,boundingBox,random,pos,lootTableId,block);
    }

}
