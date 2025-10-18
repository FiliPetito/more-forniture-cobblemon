package it.fpetito.moreforniturecobblemon;

import it.fpetito.moreforniturecobblemon.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreFornitureCobblemonDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		MoreFornitureCobblemon.LOGGER.info("[{}] - Data Generator initializing!", MoreFornitureCobblemon.MOD_ID);

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);

		MoreFornitureCobblemon.LOGGER.info("[{}] - Data Generator initialization ended", MoreFornitureCobblemon.MOD_ID);
	}
}
