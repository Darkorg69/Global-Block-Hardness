package darkorg.globalblockhardness.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfig {
    public static final Server SERVER;
    static final ForgeConfigSpec serverSpec;

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        serverSpec = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    public static void init() {
        ModLoadingContext.get().registerConfig(Type.SERVER, serverSpec);
    }

    public static class Server {
        public final DoubleValue globalBlockHardnessMultiplier;

        Server(ForgeConfigSpec.Builder pBuilder) {
            globalBlockHardnessMultiplier = pBuilder.comment(
                    "Define the global block hardness multiplier",
                    "Value of 1.0 means vanilla behaviour",
                    "Value of 0.0 means blocks will break instanly",
                    "Values greater than 1.0 means blocks will be harder to break",
                    "Values lower than 1.0 means blocks will be easier to break"
            ).defineInRange("globalBlockHardnessMultiplier", 2.0, 0.0, Float.MAX_VALUE);
        }
    }
}