package darkorg.globalblockhardness;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.config.ModConfigEvent;

@Mod(GlobalBlockHardnessCommon.MOD_ID)
public class GlobalBlockHardnessNeoForge {
    public GlobalBlockHardnessNeoForge(IEventBus pEventBus) {
        GlobalBlockHardnessCommon.LOGGER.debug("Hello, NeoForge!");
        GlobalBlockHardnessCommon.init();

        pEventBus.addListener((ModConfigEvent.Loading pEvent) -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Loading mod config file: {}", pEvent.getConfig().getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
        pEventBus.addListener((ModConfigEvent.Reloading pEvent) -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Reloading mod config file: {}", pEvent.getConfig().getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
    }
}