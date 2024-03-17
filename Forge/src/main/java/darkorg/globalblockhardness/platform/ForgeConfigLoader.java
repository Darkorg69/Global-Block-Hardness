package darkorg.globalblockhardness.platform;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import darkorg.globalblockhardness.platform.services.IConfigLoader;
import fuzs.forgeconfigapiport.forge.api.neoforge.v4.NeoForgeConfigRegistry;
import net.minecraftforge.fml.config.ModConfig;

public class ForgeConfigLoader implements IConfigLoader {
    @Override
    public void loadConfigs() {
        NeoForgeConfigRegistry.INSTANCE.register(ModConfig.Type.SERVER, GlobalBlockHardnessConfig.SERVER_SPEC);
    }
}
