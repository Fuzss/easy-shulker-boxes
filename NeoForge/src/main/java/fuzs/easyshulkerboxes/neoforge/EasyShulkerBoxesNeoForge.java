package fuzs.easyshulkerboxes.neoforge;

import fuzs.easyshulkerboxes.EasyShulkerBoxes;
import fuzs.easyshulkerboxes.data.ModItemStorageDefinitionsProvider;
import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.puzzleslib.neoforge.api.data.v2.core.NeoForgeDataProviderContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.Item;
import net.neoforged.fml.common.Mod;

import java.util.function.BiConsumer;

@Mod(EasyShulkerBoxes.MOD_ID)
public class EasyShulkerBoxesNeoForge {

    public EasyShulkerBoxesNeoForge() {
        ModConstructor.construct(EasyShulkerBoxes.MOD_ID, EasyShulkerBoxes::new);
        registerBuiltInDataProviders(EasyShulkerBoxes.SHULKER_BOXES_LOCATION,
                ModItemStorageDefinitionsProvider::registerShulkerBoxes);
        registerBuiltInDataProviders(EasyShulkerBoxes.BUNDLES_LOCATION,
                ModItemStorageDefinitionsProvider::registerBundles);
        registerBuiltInDataProviders(EasyShulkerBoxes.ENDER_CHEST_LOCATION,
                ModItemStorageDefinitionsProvider::registerEnderChest);
        registerBuiltInDataProviders(EasyShulkerBoxes.CONTAINERS_LOCATION,
                ModItemStorageDefinitionsProvider::registerContainerItems);
        registerBuiltInDataProviders(EasyShulkerBoxes.MOD_SUPPORT_LOCATION,
                ModItemStorageDefinitionsProvider::registerModProviders);
    }

    private static void registerBuiltInDataProviders(Identifier identifier, BiConsumer<ModItemStorageDefinitionsProvider, HolderLookup.RegistryLookup<Item>> providerRegistrar) {
        DataProviderHelper.registerDataProviders(identifier,
                PackType.SERVER_DATA,
                (NeoForgeDataProviderContext context) -> {
                    return ModItemStorageDefinitionsProvider.of(context, providerRegistrar);
                });
    }
}
