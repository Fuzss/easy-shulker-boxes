package fuzs.easyshulkerboxes.common.data;

import fuzs.easyshulkerboxes.common.integration.ReinforcedShulkerBoxesIntegration;
import fuzs.iteminteractions.common.api.v2.data.AbstractItemStorageDefinitionsProvider;
import fuzs.iteminteractions.common.api.v2.world.item.DyeBackedColor;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ContainerStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.EnderChestStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ItemStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.StorageOptions;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ColorCollection;

import java.util.function.BiConsumer;

public abstract class ModItemStorageDefinitionsProvider extends AbstractItemStorageDefinitionsProvider {

    ModItemStorageDefinitionsProvider(DataProviderContext context) {
        super(context);
    }

    public static DataProvider of(DataProviderContext context, BiConsumer<ModItemStorageDefinitionsProvider, HolderLookup.RegistryLookup<Item>> registrar) {
        return new ModItemStorageDefinitionsProvider(context) {
            @Override
            public void addItemStorageDefinitions(HolderLookup.Provider registries) {
                registrar.accept(this, registries.lookupOrThrow(Registries.ITEM));
            }
        };
    }

    public final void registerShulkerBoxes(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(new ContainerStorage(), Items.SHULKER_BOX);
        ColorCollection.zipApply(ColorCollection.VALUES, Items.DYED_SHULKER_BOX, (DyeColor color, Item item) -> {
            this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(color), StorageOptions.DEFAULT), item);
        });
    }

    public final void registerEnderChest(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(EnderChestStorage.INSTANCE, Items.ENDER_CHEST);
    }

    public final void registerModProviders(HolderLookup.RegistryLookup<Item> itemLookup) {
        ReinforcedShulkerBoxesIntegration.registerModProviders((Identifier identifier, ItemStorage storage) -> {
            Holder<Item> holder = Holder.Reference.createStandAlone(itemLookup,
                    ResourceKey.create(Registries.ITEM, identifier));
            this.add(identifier, storage, holder);
        });
    }
}
