package it.fpetito.moreforniturecobblemon;

import net.fabricmc.api.ClientModInitializer;

public class MoreFornitureCobblemonClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MoreFornitureCobblemon.LOGGER.info("[{}] - Client initializing!", MoreFornitureCobblemon.MOD_ID);



        MoreFornitureCobblemon.LOGGER.info("[{}] - Client initialization ended", MoreFornitureCobblemon.MOD_ID);
    }

}
