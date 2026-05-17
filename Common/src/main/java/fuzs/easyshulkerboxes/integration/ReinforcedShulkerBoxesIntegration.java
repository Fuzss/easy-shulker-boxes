package fuzs.easyshulkerboxes.integration;

import fuzs.iteminteractions.common.api.v2.world.item.DyeBackedColor;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ContainerStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.ItemStorage;
import fuzs.iteminteractions.common.api.v2.world.item.storage.StorageOptions;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import org.jspecify.annotations.Nullable;

import java.util.function.BiConsumer;

public final class ReinforcedShulkerBoxesIntegration {

    private ReinforcedShulkerBoxesIntegration() {
        // NO-OP
    }

    public static void registerModProviders(BiConsumer<Identifier, ItemStorage> registrar) {
        for (ShulkerBoxMaterial material : ShulkerBoxMaterial.values()) {
            registrar.accept(material.id(),
                    new ContainerStorage(material.width,
                            material.height,
                            null,
                            StorageOptions.DEFAULT.setFilterContainerItems()));
            for (DyeColor dyeColor : DyeColor.values()) {
                registrar.accept(material.id(dyeColor),
                        new ContainerStorage(material.width,
                                material.height,
                                DyeBackedColor.fromDyeColor(dyeColor),
                                StorageOptions.DEFAULT.setFilterContainerItems()));
            }
        }
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath("reinfshulker", path);
    }

    private enum ShulkerBoxMaterial {
        COPPER("copper", 9, 5),
        IRON("iron", 9, 6),
        GOLD("gold", 9, 9),
        DIAMOND("diamond", 12, 9),
        NETHERITE("netherite", 12, 9);

        public final String name;
        public final int width;
        public final int height;

        ShulkerBoxMaterial(String name, int width, int height) {
            this.name = name;
            this.width = width;
            this.height = height;
        }

        public Identifier id() {
            return this.id(null);
        }

        public Identifier id(@Nullable DyeColor dyeColor) {
            String path = this.name + "_shulker_box";
            if (dyeColor != null) path = "%s_%s".formatted(dyeColor.getSerializedName(), path);
            return ReinforcedShulkerBoxesIntegration.id(path);
        }
    }
}
