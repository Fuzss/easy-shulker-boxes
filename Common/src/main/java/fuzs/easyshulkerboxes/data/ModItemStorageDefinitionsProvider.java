package fuzs.easyshulkerboxes.data;

import fuzs.easyshulkerboxes.integration.ReinforcedShulkerBoxesIntegration;
import fuzs.iteminteractions.common.api.v2.data.AbstractItemStorageDefinitionsProvider;
import fuzs.iteminteractions.common.api.v2.world.item.DyeBackedColor;
import fuzs.iteminteractions.common.api.v2.world.item.storage.*;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.BiConsumer;

public abstract class ModItemStorageDefinitionsProvider extends AbstractItemStorageDefinitionsProvider {

    ModItemStorageDefinitionsProvider(DataProviderContext context) {
        super(context);
    }

    public static DataProvider of(DataProviderContext context, BiConsumer<ModItemStorageDefinitionsProvider, HolderLookup.RegistryLookup<Item>> providerRegistrar) {
        return new ModItemStorageDefinitionsProvider(context) {
            @Override
            public void addItemStorageDefinitions(HolderLookup.Provider registries) {
                providerRegistrar.accept(this, registries.lookupOrThrow(Registries.ITEM));
            }
        };
    }

    public final void registerShulkerBoxes(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(new ContainerStorage(null, StorageOptions.DEFAULT.setFilterContainerItems()), Items.SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.WHITE),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.WHITE_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.ORANGE),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.ORANGE_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.MAGENTA),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.MAGENTA_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.LIGHT_BLUE),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.LIGHT_BLUE_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.YELLOW),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.YELLOW_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.LIME),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.LIME_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.PINK),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.PINK_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.GRAY),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.GRAY_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.LIGHT_GRAY),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.LIGHT_GRAY_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.CYAN),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.CYAN_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.PURPLE),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.PURPLE_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.BLUE),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.BLUE_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.BROWN),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.BROWN_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.GREEN),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.GREEN_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.RED),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.RED_SHULKER_BOX);
        this.add(new ContainerStorage(DyeBackedColor.fromDyeColor(DyeColor.BLACK),
                StorageOptions.DEFAULT.setFilterContainerItems()), Items.BLACK_SHULKER_BOX);
    }

    public final void registerBundles(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(itemLookup,
                new BundleContentsStorage(StorageOptions.DEFAULT.setFilterContainerItems()),
                ItemTags.BUNDLES);
    }

    public final void registerEnderChest(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(EnderChestStorage.INSTANCE, Items.ENDER_CHEST);
    }

    public final void registerContainerItems(HolderLookup.RegistryLookup<Item> itemLookup) {
        this.add(Identifier.withDefaultNamespace("dispenser"),
                new ContainerStorage(3,
                        3).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY),
                Items.DISPENSER,
                Items.DROPPER);
        this.add(Identifier.withDefaultNamespace("chest"),
                new ContainerStorage(9,
                        3).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY),
                Items.CHEST,
                Items.TRAPPED_CHEST,
                Items.BARREL);
        this.add(itemLookup,
                new ContainerStorage(9,
                        3).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY),
                ItemTags.COPPER_CHESTS);
        this.add(new ContainerStorage(5,
                1).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY), Items.HOPPER);
        this.add(Identifier.withDefaultNamespace("furnace"),
                new ContainerStorage(3,
                        1).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY),
                Items.FURNACE,
                Items.BLAST_FURNACE,
                Items.SMOKER);
        this.add(new ContainerStorage(5,
                1).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY), Items.BREWING_STAND);
        this.add(Identifier.withDefaultNamespace("campfire"),
                new ContainerStorage(4,
                        1).interactionPermissions(ContainerStorage.InteractionPermissions.CREATIVE_ONLY),
                Items.CAMPFIRE,
                Items.SOUL_CAMPFIRE);
    }

    public final void registerModProviders(HolderLookup.RegistryLookup<Item> itemLookup) {
        ReinforcedShulkerBoxesIntegration.registerModProviders((Identifier identifier, ItemStorage storage) -> {
            Holder<Item> holder = Holder.Reference.createStandAlone(itemLookup,
                    ResourceKey.create(Registries.ITEM, identifier));
            this.add(identifier, storage, holder);
        });
    }
}
