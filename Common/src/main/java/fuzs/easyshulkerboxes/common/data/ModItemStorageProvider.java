package fuzs.easyshulkerboxes.common.data;

import fuzs.easyshulkerboxes.common.integration.ReinforcedShulkerBoxesIntegration;
import fuzs.iteminteractions.common.api.v2.data.ItemStorageProvider;
import fuzs.iteminteractions.common.api.v2.world.item.DyeBackedColor;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ContainerStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.EnderChestStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ItemStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.StorageOptions;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.ColorCollection;

import java.util.function.BiConsumer;

public abstract class ModItemStorageProvider implements ItemStorageProvider {

    public static ItemStorageProvider of(BiConsumer<ModItemStorageProvider, BootstrapContext<ItemStorage.Definition>> registrar) {
        return new ModItemStorageProvider() {
            @Override
            public void run(BootstrapContext<ItemStorage.Definition> output) {
                registrar.accept(this, output);
            }
        };
    }

    public final void registerShulkerBoxes(BootstrapContext<ItemStorage.Definition> output) {
        this.add(output, new ContainerStorage(), Items.SHULKER_BOX);
        ColorCollection.zipApply(ColorCollection.VALUES, Items.DYED_SHULKER_BOX, (DyeColor color, Item item) -> {
            this.add(output, new ContainerStorage(DyeBackedColor.fromDyeColor(color), StorageOptions.DEFAULT), item);
        });
    }

    public final void registerEnderChest(BootstrapContext<ItemStorage.Definition> output) {
        this.add(output, EnderChestStorage.INSTANCE, Items.ENDER_CHEST);
    }

    public final void registerModProviders(BootstrapContext<ItemStorage.Definition> output) {
        ReinforcedShulkerBoxesIntegration.registerModProviders((Identifier identifier, ItemStorage storage) -> {
            Holder<Item> holder = Holder.Reference.createStandAlone(output.lookup(Registries.ITEM),
                    ResourceKey.create(Registries.ITEM, identifier));
            this.add(output, identifier, storage, HolderSet.direct(holder));
        });
    }
}
