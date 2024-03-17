package darkorg.globalblockhardness;

import darkorg.globalblockhardness.platform.Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GlobalBlockHardnessCommon {
    public static final String MOD_ID = "globalblockhardness";
    public static final String MOD_NAME = "Global Block Hardness";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        GlobalBlockHardnessCommon.LOGGER.debug("Hello from Common init on {}! we are currently in a {} environment!", Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());
        Services.CONFIG_LOADER.loadConfigs();
    }
}