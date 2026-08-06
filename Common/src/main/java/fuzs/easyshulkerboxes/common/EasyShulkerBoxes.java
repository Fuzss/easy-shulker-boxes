package fuzs.easyshulkerboxes.common;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.common.api.core.v1.context.PackRepositorySourcesContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EasyShulkerBoxes implements ModConstructor {
    public static final String MOD_ID = "easyshulkerboxes";
    public static final String MOD_NAME = "Easy Shulker Boxes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static final Identifier SHULKER_BOXES_ID = id("shulker_boxes");
    public static final Identifier ENDER_CHEST_ID = id("ender_chest");
    public static final Identifier MOD_SUPPORT_ID = id("mod_support");

    @Override
    public void onAddDataPackFinders(PackRepositorySourcesContext context) {
        context.registerBuiltInPack(SHULKER_BOXES_ID, Component.literal("Shulker Boxes"), true);
        context.registerBuiltInPack(ENDER_CHEST_ID, Component.literal("Ender Chest"), true);
        context.registerBuiltInPack(MOD_SUPPORT_ID, Component.literal("Mod Support"), false);
    }

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }
}
