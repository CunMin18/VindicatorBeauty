package org.cunmin18.vindicator_beauty.mixins;

import net.minecraft.structure.SimpleStructurePiece;
import net.minecraft.structure.StructurePlacementData;
import org.cunmin18.vindicator_beauty.utils.ISimpleStructurePieceMixin;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(SimpleStructurePiece.class)
public class SimpleStructurePieceMixin implements ISimpleStructurePieceMixin {
    @Shadow
    protected StructurePlacementData placementData;

    @Override
    public StructurePlacementData getStructurePlacementData() {
        return placementData;
    }
}
