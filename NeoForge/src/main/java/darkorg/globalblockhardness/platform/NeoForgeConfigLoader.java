package darkorg.globalblockhardness.platform;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import darkorg.globalblockhardness.platform.services.IConfigLoader;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;

public class NeoForgeConfigLoader implements IConfigLoader {
    @Override
    public void loadConfigs() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, GlobalBlockHardnessConfig.SERVER_SPEC);
    }
}
