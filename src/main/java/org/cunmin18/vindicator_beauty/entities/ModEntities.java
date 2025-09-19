package org.cunmin18.vindicator_beauty.entities;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.cunmin18.vindicator_beauty.VindicatorBeauty;

public class ModEntities {
    public static EntityType<VindicatorBeautyEntity> VINDICATOR_BEAUTY_ENTITY_TYPE = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VindicatorBeautyEntity::new).dimensions(EntityDimensions.fixed(0.9F, 1.4F)).build();
    private static void registerEntity(String entityName, EntityType<?> entityType){
        Registry.register(Registries.ENTITY_TYPE,new Identifier(VindicatorBeauty.modName,entityName),entityType);
    }
    public static void register(){
        registerEntity("vindicator_beauty",VINDICATOR_BEAUTY_ENTITY_TYPE);
        FabricDefaultAttributeRegistry.register(VINDICATOR_BEAUTY_ENTITY_TYPE,VindicatorBeautyEntity.createAttributes());
    }
}
