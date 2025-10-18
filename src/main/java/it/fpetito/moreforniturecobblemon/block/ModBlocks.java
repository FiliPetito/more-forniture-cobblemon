package it.fpetito.moreforniturecobblemon.block;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.custom.GraveBlock;
import it.fpetito.moreforniturecobblemon.block.custom.GraveVariant;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GRAVE= registerBlock("grave",
            new GraveBlock(Block.Settings.create().nonOpaque()), true);


    private static Block registerBlock(String name, Block block, boolean hasVariants) {
        if (!hasVariants) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreFornitureCobblemon.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerVariantBlockItemGrave() {

        // per ogni variante, registra un item distinto che piazza lo stesso blocco
        for (GraveVariant v : GraveVariant.values()) {
            String itemName = "grave_" + v.asString(); // grave_default, grave_gray...
            Registry.register(Registries.ITEM,
                    Identifier.of(MoreFornitureCobblemon.MOD_ID, itemName),
                    new BlockItem(GRAVE, new Item.Settings()));
        }

    }

    public static void registerModBlocks() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering ModBlocks.", MoreFornitureCobblemon.MOD_ID);
    }
}
