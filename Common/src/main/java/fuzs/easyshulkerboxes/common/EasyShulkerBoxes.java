package fuzs.easyshulkerboxes.common;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.common.api.core.v1.context.ItemComponentsContext;
import fuzs.puzzleslib.common.api.core.v1.context.PackRepositorySourcesContext;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.TooltipDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyShulkerBoxes implements ModConstructor {
    public static final String MOD_ID = "easyshulkerboxes";
    public static final String MOD_NAME = "Easy Shulker Boxes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final Identifier SHULKER_BOXES_LOCATION = id("shulker_boxes");
    public static final Identifier ENDER_CHEST_LOCATION = id("ender_chest");
    public static final Identifier MOD_SUPPORT_LOCATION = id("mod_support");

    @Override
    public void onAddDataPackFinders(PackRepositorySourcesContext context) {
        context.registerBuiltInPack(SHULKER_BOXES_LOCATION, Component.literal("Shulker Boxes"), true);
        context.registerBuiltInPack(ENDER_CHEST_LOCATION, Component.literal("Ender Chest"), true);
        context.registerBuiltInPack(MOD_SUPPORT_LOCATION, Component.literal("Mod Support"), false);
    }

    @Override
    public void onRegisterItemComponentPatches(ItemComponentsContext context) {
        context.registerItemComponentsPatch((DataComponentGetter components, DataComponentMap.Builder builder, HolderLookup.Provider registries, Item item) -> {
            if (components.get(DataComponents.CONTAINER) != null && registries.getOrThrow(ItemTags.SHULKER_BOXES)
                    .contains(item.builtInRegistryHolder())) {
                builder.set(DataComponents.TOOLTIP_DISPLAY,
                        TooltipDisplay.DEFAULT.withHidden(DataComponents.CONTAINER, true));
            }
        });
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
