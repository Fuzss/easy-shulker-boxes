package fuzs.easyshulkerboxes.fabric;

import fuzs.easyshulkerboxes.EasyShulkerBoxes;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import net.fabricmc.api.ModInitializer;

public class EasyShulkerBoxesFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(EasyShulkerBoxes.MOD_ID, EasyShulkerBoxes::new);
    }
}
