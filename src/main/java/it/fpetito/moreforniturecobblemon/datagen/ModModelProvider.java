package it.fpetito.moreforniturecobblemon.datagen;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Mod Block Model Provider initializing", MoreFornitureCobblemon.MOD_ID);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.GRAVE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.POKE_BALL);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BASE_STATUE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.POKE_BALL_STATUE);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Mod Item Model Provider initializing", MoreFornitureCobblemon.MOD_ID);

    }
}