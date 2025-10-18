package it.fpetito.moreforniturecobblemon.block;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.custom.GraveBlock;
import it.fpetito.moreforniturecobblemon.block.custom.GraveVariant;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block GRAVE = registerBlock("grave",
            new GraveBlock(Block.Settings.create().nonOpaque()), true);

    public static final Block POKE_BALL = registerBlock("poke_ball",
            new PokeBallBlock(Block.Settings.create().nonOpaque()), true);

//    public static final List<Block> POKE_BALL_LIST = registeryPokeBallList();
//
//    private static List<Block> registeryPokeBallList() {
//
//        List<Block> blocks = new ArrayList<>();
//
//        for(PokeBallVariant v : PokeBallVariant.values()) {
//            Block pokeBall = Registry.register(Registries.BLOCK, Identifier.of(MoreFornitureCobblemon.MOD_ID, v.asString()), new PokeBall(Block.Settings.create().nonOpaque()));
//            blocks.add(pokeBall);
//        }
//
//        return blocks;
//    }


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

    //public static void registerVariantBlockItemBall() {
    //    for (PokeBallVariant v : PokeBallVariant.values()) {
//
    //        String itemId = v.asString(); // esempio: pokeball_normal
//
    //        //Block pokeBall = Registries.BLOCK.get(Identifier.of(MoreFornitureCobblemon.MOD_ID, itemId));
//
    //        Registry.register(Registries.ITEM,
    //                Identifier.of(MoreFornitureCobblemon.MOD_ID, itemId),
    //                new BlockItem(POKE_BALL, new Item.Settings()));
    //    }
    //}

    public static void registerModBlocks() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering ModBlocks.", MoreFornitureCobblemon.MOD_ID);
    }


}
