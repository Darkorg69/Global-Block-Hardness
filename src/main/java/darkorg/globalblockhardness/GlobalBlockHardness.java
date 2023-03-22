package darkorg.globalblockhardness;

import darkorg.globalblockhardness.config.ModConfig;
import net.minecraftforge.fml.common.Mod;

@Mod(GlobalBlockHardness.MOD_ID)
public class GlobalBlockHardness {
    public static final String MOD_ID = "globalblockhardness";

    public GlobalBlockHardness() {
        ModConfig.init();
    }
}
