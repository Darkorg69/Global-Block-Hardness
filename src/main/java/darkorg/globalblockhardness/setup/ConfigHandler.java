package darkorg.globalblockhardness.setup;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class ConfigHandler {
    public static ForgeConfigSpec SERVER_CONFIG;
    public static ForgeConfigSpec.BooleanValue globalHardnessEnabled;
    public static ForgeConfigSpec.DoubleValue globalHardnessMultiplier;

    public static void init() {
        initServer();
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG);
    }

    private static void initServer() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("GlobalBlockHardness configuration file:");
        globalHardnessEnabled = builder.comment("Set to false to disable the GlobalHardness feature.").define("globalhardness_enabled", true);
        globalHardnessMultiplier = builder.comment("Set how much block hardness will be multiplied globally.").defineInRange("globalhardness_multiplier", 2.0, 0.0, Float.MAX_VALUE);
        builder.pop();
        SERVER_CONFIG = builder.build();
    }
}


