package darkorg.globalblockhardness.config;

import darkorg.globalblockhardness.GlobalBlockHardness;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

public class ModConfig {
    public static float globalBlockHardnessMultiplier;

    public static Configuration config;

    public static void init(FMLPreInitializationEvent event) {
        config = new Configuration(new File(event.getModConfigurationDirectory() + "/" + GlobalBlockHardness.MOD_ID + ".cfg"));

        globalBlockHardnessMultiplier = config.getFloat("globalBlockHardnessMultiplier", "general", 2.0F, 0.0F, Float.MAX_VALUE, "Define the global block hardness multiplier\n" +
                "Value of 1.0 means vanilla behaviour\n" +
                "Value of 0.0 means blocks will break instanly\n" +
                "Values greater than 1.0 means blocks will be harder to break\n" +
                "Values lower than 1.0 means blocks will be easier to break");

        config.save();
    }
}