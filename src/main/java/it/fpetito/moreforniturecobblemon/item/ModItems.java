package it.fpetito.moreforniturecobblemon.item;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.ModBlocks;
import it.fpetito.moreforniturecobblemon.block.custom.ElementalEnergyVariant;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallVariant;
import it.fpetito.moreforniturecobblemon.item.custom.ElementalEnergyItem;
import it.fpetito.moreforniturecobblemon.item.custom.PokeBallItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> POKE_BALL_ITEM_LIST = registeryPokeBallItemList();
    public static final List<Item> ELEMENTAL_ENERGY_ITEM_LIST = registeryElementalEnergyItemList();

    public static final Item ELECTRIC_SPHERE = registerItem("electric_sphere",
            new Item(new Item.Settings()));

    public static final Item FIRE_SPHERE = registerItem("fire_sphere",
            new Item(new Item.Settings()));

    public static final Item WATER_SPHERE = registerItem("water_sphere",
            new Item(new Item.Settings()));

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

    private static List<Item> registeryElementalEnergyItemList() {
        List<Item> items = new ArrayList<>();

        for(ElementalEnergyVariant v : ElementalEnergyVariant.values()) {
            Item elementalEnergy = Registry.register(
                    Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, "elemental_energy/" + v.asString()),
                    new ElementalEnergyItem(ModBlocks.ELEMENTAL_ENERGY, new Item.Settings(), v));

            items.add(elementalEnergy);
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
