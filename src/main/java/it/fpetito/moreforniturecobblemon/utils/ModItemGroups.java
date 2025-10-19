package it.fpetito.moreforniturecobblemon.utils;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.ModBlocks;
import it.fpetito.moreforniturecobblemon.block.custom.GraveVariant;
import it.fpetito.moreforniturecobblemon.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups extends ItemGroups {


    public static final ItemGroup MORE_FORNITURE_COBBLEMON  = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(MoreFornitureCobblemon.MOD_ID, "more-forniture-cobblemon"),
            FabricItemGroup.builder()
                    //Icona che vogliamo visualizzare nella pagina della mod
                    .icon(() -> new ItemStack(ModBlocks.POKE_BALL_STATUE))

                    //Nome della mod da visualizzare
                    .displayName(Text.translatable("itemgroup.more-forniture-cobblemon"))

                    .entries(((displayContext, entries) -> {

                        for (GraveVariant v : GraveVariant.values()) {
                            String itemId = "grave_" + v.asString();
                            Item item = Registries.ITEM.get(Identifier.of(MoreFornitureCobblemon.MOD_ID, itemId));
                            if (item != null) entries.add(item);
                        }


                        for(Item item : ModItems.POKE_BALL_ITEM_LIST) {
                            entries.add(item);
                        }

                        entries.add(ModBlocks.BASE_STATUE);
                        entries.add(ModBlocks.POKE_BALL_STATUE);

                    }))
                    .build()
    );

    public static void registerItemGroups(){
        MoreFornitureCobblemon.LOGGER.info("[{}] - Registering Item Groups!", MoreFornitureCobblemon.MOD_ID);
    }
}
