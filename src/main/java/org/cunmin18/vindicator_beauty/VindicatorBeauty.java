package org.cunmin18.vindicator_beauty;

import net.fabricmc.api.ModInitializer;
import org.cunmin18.vindicator_beauty.entities.ModEntities;

public class VindicatorBeauty implements ModInitializer {
    public static String modName = "vindicator_beauty";
    @Override
    public void onInitialize() {
        ModEntities.register();
    }
}
