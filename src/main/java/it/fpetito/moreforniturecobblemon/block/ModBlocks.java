package it.fpetito.moreforniturecobblemon.block;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.custom.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BASE_STATUE = registerBlock("base_statue",
            new BaseStatue(Block.Settings.create().nonOpaque()), false);

    public static final Block POKE_BALL_STATUE = registerBlock("poke_ball_statue",
            new PokeBallStatue(Block.Settings.create().nonOpaque()), false);

    public static final Block GRAVE = registerBlock("grave",
            new GraveBlock(Block.Settings.create().nonOpaque()), true);

    public static final Block POKE_BALL = registerBlock("poke_ball",
            new PokeBallBlock(Block.Settings.create().nonOpaque()), true);

    public static final Block ELEMENTAL_ENERGY = registerBlock("elemental_energy",
            new ElementalEnergyBlock(Block.Settings.create().nonOpaque()), true);


    private static Block registerBlock(String name, Block block, boolean hasVariants) {
        if (!hasVariants) registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MoreFornitureCobblemon.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerVariantBlockItemGrave() {
        for (GraveVariant v : GraveVariant.values()) {
            String itemId = "grave_" + v.asString(); // grave_default, grave_gray...
            Registry.register(Registries.ITEM,
                    Identifier.of(MoreFornitureCobblemon.MOD_ID, itemId),
                    new BlockItem(GRAVE, new Item.Settings()));
        }
    }



    public static void registerModBlocks() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering ModBlocks.", MoreFornitureCobblemon.MOD_ID);
    }


}
