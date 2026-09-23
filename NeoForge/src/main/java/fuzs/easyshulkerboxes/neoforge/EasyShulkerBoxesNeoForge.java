package fuzs.easyshulkerboxes.neoforge;

import fuzs.easyshulkerboxes.common.EasyShulkerBoxes;
import fuzs.easyshulkerboxes.common.data.ModItemStorageProvider;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ItemStorage;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import net.minecraft.server.packs.PackType;
import net.neoforged.fml.common.Mod;

@Mod(EasyShulkerBoxes.MOD_ID)
public class EasyShulkerBoxesNeoForge {

    public EasyShulkerBoxesNeoForge() {
        ModConstructor.construct(EasyShulkerBoxes.MOD_ID, EasyShulkerBoxes::new);
        DataProviderBuilder.ofBuiltIn(EasyShulkerBoxes.SHULKER_BOXES_ID, PackType.SERVER_DATA)
                .add(ItemStorage.Definition.REGISTRY_KEY,
                        ModItemStorageProvider.of(ModItemStorageProvider::registerShulkerBoxes));
        DataProviderBuilder.ofBuiltIn(EasyShulkerBoxes.ENDER_CHEST_ID, PackType.SERVER_DATA)
                .add(ItemStorage.Definition.REGISTRY_KEY,
                        ModItemStorageProvider.of(ModItemStorageProvider::registerEnderChest));
        DataProviderBuilder.ofBuiltIn(EasyShulkerBoxes.MOD_SUPPORT_ID, PackType.SERVER_DATA)
                .add(ItemStorage.Definition.REGISTRY_KEY,
                        ModItemStorageProvider.of(ModItemStorageProvider::registerModProviders));
    }
}
