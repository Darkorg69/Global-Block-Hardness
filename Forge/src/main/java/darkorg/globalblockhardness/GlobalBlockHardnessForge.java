package darkorg.globalblockhardness;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlobalBlockHardnessCommon.MOD_ID)
public class GlobalBlockHardnessForge {
    public GlobalBlockHardnessForge() {
        GlobalBlockHardnessCommon.LOGGER.debug("Hello, Forge!");

        GlobalBlockHardnessCommon.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener((ModConfigEvent.Loading pEvent) -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Loading mod config file: {}", pEvent.getConfig().getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
        FMLJavaModLoadingContext.get().getModEventBus().addListener((ModConfigEvent.Reloading pEvent) -> {
            GlobalBlockHardnessCommon.LOGGER.debug("Reloading mod config file: {}", pEvent.getConfig().getFileName());
            GlobalBlockHardnessConfig.bakeConfig();
        });
    }
}
