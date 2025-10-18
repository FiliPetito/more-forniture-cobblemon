package it.fpetito.moreforniturecobblemon.item;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.ModBlocks;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallVariant;
import it.fpetito.moreforniturecobblemon.item.custom.PokeBallItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> POKE_BALL_ITEM_LIST = registeryPokeBallItemList();

    private static List<Item> registeryPokeBallItemList() {
        List<Item> items = new ArrayList<>();

        for(PokeBallVariant v : PokeBallVariant.values()) {
            Item pokeBallItem = Registry.register(
                    Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, "poke_balls/" + v.asString()),
                    new PokeBallItem(ModBlocks.POKE_BALL, new Item.Settings(), v));

            items.add(pokeBallItem);
        }
        return items;
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering ModItems.", MoreFornitureCobblemon.MOD_ID);
    }
}
