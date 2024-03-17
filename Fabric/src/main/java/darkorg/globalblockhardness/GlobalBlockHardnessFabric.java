package darkorg.globalblockhardness;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeModConfigEvents;
import net.fabricmc.api.ModInitializer;

public class GlobalBlockHardnessFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GlobalBlockHardnessCommon.LOGGER.debug("Hello, Fabric!");
        GlobalBlockHardnessCommon.init();

        NeoForgeModConfigEvents.loading(GlobalBlockHardnessCommon.MOD_ID).register(pModConfig -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Loading mod config file: {}", pModConfig.getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
        NeoForgeModConfigEvents.reloading(GlobalBlockHardnessCommon.MOD_ID).register(pModConfig -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Reloading mod config file: {}", pModConfig.getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
    }
}
