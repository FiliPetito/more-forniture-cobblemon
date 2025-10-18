package it.fpetito.moreforniturecobblemon;

import it.fpetito.moreforniturecobblemon.block.ModBlocks;
import it.fpetito.moreforniturecobblemon.item.ModItems;
import it.fpetito.moreforniturecobblemon.utils.ModItemGroups;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreFornitureCobblemon implements ModInitializer {

	public static final String MOD_ID = "more-forniture-cobblemon";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);



	@Override
	public void onInitialize() {
		LOGGER.info("[{}] - Initializing the mod!", MOD_ID);

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerVariantBlockItemGrave();
		//ModBlocks.registerVariantBlockItemBall();


		LOGGER.info("[{}] - Initialization ended", MOD_ID);
	}
}