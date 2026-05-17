package fuzs.easyshulkerboxes.client;

import fuzs.easyshulkerboxes.EasyShulkerBoxes;
import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.common.api.config.v3.ConfigHolder;

public class EasyShulkerBoxesClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        ConfigHolder.registerConfigurationScreen(EasyShulkerBoxes.MOD_ID, "iteminteractions");
    }
}
