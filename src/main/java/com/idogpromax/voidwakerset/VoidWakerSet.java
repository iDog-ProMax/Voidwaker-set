package com.idogpromax.voidwakerset;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class VoidWakerSet implements ModInitializer {
    public static final String MOD_ID = "void_waker_set";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block DRAGONITE_ORE = registerBlock(
            "dragonite_ore",
            properties -> new Block(properties
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

        // TEST MODE: add all four armour pieces to every End City treasure chest.
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (source.isBuiltin()
                    && BuiltInLootTables.END_CITY_TREASURE.equals(key)) {

                tableBuilder.withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(VOID_WAKER_HELMET))
                );

                tableBuilder.withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(VOID_WAKER_CHESTPLATE))
                );

                tableBuilder.withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(VOID_WAKER_LEGGINGS))
                );

                tableBuilder.withPool(
                        LootPool.lootPool()
                                .add(LootItem.lootTableItem(VOID_WAKER_BOOTS))
                );
            }
        });

        LOGGER.info("Void Waker Set registered. End City armour test loot enabled.");
    }

    private static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

    private static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, id(name));
    }

    private static ResourceKey<Item> itemKey(String name) {
        return ResourceKey.create(Registries.ITEM, id(name));
    }

    private static Item registerItem(String name) {
        ResourceKey<Item> key = itemKey(name);
        Item item = new Item(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    private static Block registerBlock(
            String name,
            Function<BlockBehaviour.Properties, Block> factory
    ) {
        ResourceKey<Block> key = blockKey(name);
        Block block = factory.apply(
                BlockBehaviour.Properties.of().setId(key)
        );
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }

    private static Item registerBlockItem(String name, Block block) {
        ResourceKey<Item> key = itemKey(name);
        BlockItem item = new BlockItem(
                block,
                new Item.Properties().setId(key).useBlockDescriptionPrefix()
        );
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
