package darkorg.globalblockhardness;

import darkorg.globalblockhardness.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GlobalBlockHardness.MOD_ID, name = GlobalBlockHardness.NAME, version = GlobalBlockHardness.VERSION)
public class GlobalBlockHardness {
    public static final String MOD_ID = "globalblockhardness";
    public static final String NAME = "Global Block Hardness";
    public static final String VERSION = "1.0.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModConfig.init(event);
    }
}
