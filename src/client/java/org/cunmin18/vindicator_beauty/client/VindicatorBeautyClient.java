package org.cunmin18.vindicator_beauty.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.cunmin18.vindicator_beauty.client.entities.ModModelLayers;
import org.cunmin18.vindicator_beauty.client.entities.VindicatorBeautyEntityModel;
import org.cunmin18.vindicator_beauty.client.entities.VindicatorBeautyEntityRenderer;
import org.cunmin18.vindicator_beauty.entities.ModEntities;

public class VindicatorBeautyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.VINDICATOR_BEAUTY_ENTITY_TYPE, VindicatorBeautyEntityRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VINDICATOR_BEAUTY, VindicatorBeautyEntityModel::getTexturedModelData);
    }
}
