package org.cunmin18.vindicator_beauty.mixins;


import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.structure.WoodlandMansionGenerator;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.cunmin18.vindicator_beauty.entities.ModEntities;
import org.cunmin18.vindicator_beauty.utils.ISimpleStructurePieceMixin;
import org.cunmin18.vindicator_beauty.utils.IStructurePieceMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(WoodlandMansionGenerator.Piece.class)
public class WoodlandMansionGeneratorMixin {
    @Inject(method = "handleMetadata",at = @At("HEAD"),cancellable = true)
    protected void handleMetadata(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox, CallbackInfo ci) {
        if (metadata.startsWith("Chest")) {
            var piece = (WoodlandMansionGenerator.Piece)(Object)this;
            var simpleStructurePiece = (ISimpleStructurePieceMixin)piece;
            BlockRotation blockRotation = simpleStructurePiece.getStructurePlacementData().getRotation();
            BlockState blockState = Blocks.CHEST.getDefaultState();
            if ("ChestWest".equals(metadata)) {
                blockState = (BlockState)blockState.with(ChestBlock.FACING, blockRotation.rotate(Direction.WEST));
            } else if ("ChestEast".equals(metadata)) {
                blockState = (BlockState)blockState.with(ChestBlock.FACING, blockRotation.rotate(Direction.EAST));
            } else if ("ChestSouth".equals(metadata)) {
                blockState = (BlockState)blockState.with(ChestBlock.FACING, blockRotation.rotate(Direction.SOUTH));
            } else if ("ChestNorth".equals(metadata)) {
                blockState = (BlockState)blockState.with(ChestBlock.FACING, blockRotation.rotate(Direction.NORTH));
            }
            var structurePiece = (IStructurePieceMixin)piece;
            structurePiece.callAddChest(world, boundingBox, random, pos, LootTables.WOODLAND_MANSION_CHEST, blockState);
        } else {
            List<MobEntity> list = new ArrayList();
            switch (metadata) {
                case "Mage":
                    list.add((MobEntity) EntityType.EVOKER.create(world.toServerWorld()));
                    break;
                case "Warrior":
                    var r = world.getRandom().nextInt(2) + 1;
                    var type =  r == 2 ? EntityType.VINDICATOR : ModEntities.VINDICATOR_BEAUTY_ENTITY_TYPE;
                    list.add((MobEntity)type.create(world.toServerWorld()));
                    break;
                case "Group of Allays":
                    int i = world.getRandom().nextInt(3) + 1;

                    for(int j = 0; j < i; ++j) {
                        list.add((MobEntity)EntityType.ALLAY.create(world.toServerWorld()));
                    }
                    break;
                default:
                    return;
            }

            for(MobEntity mobEntity : list) {
                if (mobEntity != null) {
                    mobEntity.setPersistent();
                    mobEntity.refreshPositionAndAngles(pos, 0.0F, 0.0F);
                    mobEntity.initialize(world, world.getLocalDifficulty(mobEntity.getBlockPos()), SpawnReason.STRUCTURE, (EntityData)null, (NbtCompound)null);
                    world.spawnEntityAndPassengers(mobEntity);
                    world.setBlockState(pos, Blocks.AIR.getDefaultState(), 2);
                }
            }
        }
        ci.cancel();

    }
}
