package it.fpetito.moreforniturecobblemon.item;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MoreFornitureCobblemon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering ModItems.", MoreFornitureCobblemon.MOD_ID);
    }
}
