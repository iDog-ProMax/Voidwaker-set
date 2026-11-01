package com.idogpromax.voidwakerset;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Initial content-registration pass for Void Waker Set.
 *
 * This intentionally keeps the first build to vanilla registry APIs. The
 * custom equipment names/items and Dragonite ore are registered here; see
 * README for the gameplay systems that still need implementation/testing
 * against the final 26.3 mappings.
 */
public class VoidWakerSet implements ModInitializer {
    public static final String MOD_ID = "void_waker_set";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block DRAGONITE_ORE = registerBlock(
            "dragonite_ore",
            new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops())
    );

    public static final Item DRAGONITE_ORE_ITEM =
            registerBlockItem("dragonite_ore", DRAGONITE_ORE);

    public static final Item DRAGONITE_INGOT = registerItem("dragonite_ingot");
    public static final Item VOID_WAKER_HELMET = registerItem("void_waker_helmet");
    public static final Item VOID_WAKER_CHESTPLATE = registerItem("void_waker_chestplate");
    public static final Item VOID_WAKER_LEGGINGS = registerItem("void_waker_leggings");
    public static final Item VOID_WAKER_BOOTS = registerItem("void_waker_boots");
    public static final Item VOID_WAKER_SWORD = registerItem("void_waker_sword");
    public static final Item VOID_WAKER_PICKAXE = registerItem("void_waker_pickaxe");
    public static final Item VOID_WAKER_AXE = registerItem("void_waker_axe");
    public static final Item VOID_WAKER_SHOVEL = registerItem("void_waker_shovel");
    public static final Item VOID_WAKER_HOE = registerItem("void_waker_hoe");

    @Override
    public void onInitialize() {
        LOGGER.info("Void Waker Set content registered.");
    }

    private static Item registerItem(String name) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(MOD_ID, name),
                new Item(new Item.Properties())
        );
    }

    private static Block registerBlock(String name, Block block) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                Identifier.fromNamespaceAndPath(MOD_ID, name),
                block
        );
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                Identifier.fromNamespaceAndPath(MOD_ID, name),
                new BlockItem(block, new Item.Properties())
        );
    }
}
