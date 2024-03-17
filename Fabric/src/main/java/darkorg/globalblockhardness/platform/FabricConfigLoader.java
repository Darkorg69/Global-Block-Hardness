package darkorg.globalblockhardness.platform;

import darkorg.globalblockhardness.GlobalBlockHardnessCommon;
import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import darkorg.globalblockhardness.platform.services.IConfigLoader;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeModConfigEvents;
import net.neoforged.fml.config.ModConfig;

public class FabricConfigLoader implements IConfigLoader {
    @Override
    public void loadConfigs() {
        NeoForgeConfigRegistry.INSTANCE.register(GlobalBlockHardnessCommon.MOD_ID, ModConfig.Type.SERVER, GlobalBlockHardnessConfig.SERVER_SPEC);
    }
}
