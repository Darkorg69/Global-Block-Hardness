package darkorg.globalblockhardness.platform;

import darkorg.globalblockhardness.GlobalBlockHardnessCommon;
import darkorg.globalblockhardness.platform.services.IConfigLoader;
import darkorg.globalblockhardness.platform.services.IPlatformHelper;

import java.util.ServiceLoader;

public class Services {
    public static final IConfigLoader CONFIG_LOADER = load(IConfigLoader.class);
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);

    public static <T> T load(Class<T> pService) {
        final T loadedService = ServiceLoader.load(pService).findFirst().orElseThrow(() -> {
            return new NullPointerException("Failed to load service for " + pService.getName());
        });

        GlobalBlockHardnessCommon.LOGGER.debug("Loaded {} for service {}", loadedService, pService);

        return loadedService;
    }
}