package org.cunmin18.vindicator_beauty.client.entities;

import net.minecraft.client.render.*;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import org.cunmin18.vindicator_beauty.VindicatorBeauty;
import org.cunmin18.vindicator_beauty.entities.VindicatorBeautyEntity;


public class VindicatorBeautyEntityRenderer extends MobEntityRenderer<VindicatorBeautyEntity,VindicatorBeautyEntityModel<VindicatorBeautyEntity>> {
    private static final Identifier TEXTURE = new Identifier(VindicatorBeauty.modName,"textures/entity/vindicator_beauty/vindicator_beauty.png");
    public VindicatorBeautyEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new VindicatorBeautyEntityModel<>(context.getPart(ModModelLayers.VINDICATOR_BEAUTY)), 0.3F);
    }
    @Override
    public Identifier getTexture(VindicatorBeautyEntity entity) {
        return TEXTURE;
    }
}


