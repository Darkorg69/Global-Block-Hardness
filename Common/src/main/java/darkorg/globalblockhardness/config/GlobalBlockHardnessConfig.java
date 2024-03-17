package darkorg.globalblockhardness.config;

import darkorg.globalblockhardness.GlobalBlockHardnessCommon;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.Builder;
import net.neoforged.neoforge.common.ModConfigSpec.DoubleValue;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalBlockHardnessConfig {
    public static final Server SERVER;
    public static final ModConfigSpec SERVER_SPEC;

    public static List<Block> whitelist;
    public static List<Block> blacklist;
    public static Map<Block, Float> override;

    static {
        final Pair<Server, ModConfigSpec> specPair = new Builder().configure(Server::new);
        SERVER = specPair.getLeft();
        SERVER_SPEC = specPair.getRight();
    }

    public static class Server {
        public final DoubleValue blockHardnessMultiplier;
        public final ModConfigSpec.ConfigValue<String> override;
        public final ModConfigSpec.ConfigValue<String> blacklist;
        public final ModConfigSpec.ConfigValue<String> whitelist;
        public final ModConfigSpec.ConfigValue<Boolean> whitelistEnabled;

        Server(Builder pBuilder) {
            blockHardnessMultiplier = pBuilder.comment("Block Hardness Multiplier", "1.0 - Vanilla", "0.0 - Instant-break", "> 1.0 - Blocks become harder to break").defineInRange("blockHardnessMultiplier", 2.0, 0.0, Float.MAX_VALUE);
            whitelistEnabled = pBuilder.comment("Whitelist Enabled", "If whitelist is enabled, blacklist is disabled").define("whitelistEnabled", false);
            whitelist = pBuilder.comment("Whitelisted blocks", "Mod will only change the hardness of these blocks").define("whitelist", "examplemod:example_block, anothermod:another_block");
            blacklist = pBuilder.comment("Blacklisted blocks", "Mod will not change the behaviour on these blocks").define("blacklist", "examplemod:example_block, anothermod:another_block");
            override = pBuilder.comment("Overridden blocks", "Mod will override hardness on these blocks regardless of whitelist and blacklist").define("override", "examplemod:example_block=10.0, anothermod:another_block=10.0");
        }
    }

    public static void bakeConfig() {
        whitelist = parseBlockListConfig(SERVER.whitelist);
        blacklist = parseBlockListConfig(SERVER.blacklist);
        override = parseBlockFloatMapConfig(SERVER.override);
    }

    public static Map<Block, Float> parseBlockFloatMapConfig(ModConfigSpec.ConfigValue<String> pConfigList) {
        Map<Block, Float> blockMap = new HashMap<>();

        //Strip all white-spaces from the config value
        String config = pConfigList.get().replaceAll("\\s+", "");

        if (!config.isEmpty()) {
            if (config.matches("^\\w+:\\w+=\\d+(\\.\\d+)?(,\\w+:\\w+=\\d+(\\.\\d+)?)*$")) {
                String[] split = config.strip().split(",");

                for (String entry : split) {
                    String[] splitEntry = entry.strip().split("=");
                    String[] splitBlock = splitEntry[0].split(":");
                    blockMap.put(BuiltInRegistries.BLOCK.get(new ResourceLocation(splitBlock[0], splitBlock[1])), Float.parseFloat(splitEntry[1]));
                }
            } else {
                GlobalBlockHardnessCommon.LOGGER.error("Malformed config value! Cannot parse: [{}]", config);
            }
        }

        return blockMap;
    }

    private static List<Block> parseBlockListConfig(ModConfigSpec.ConfigValue<String> pConfigList) {
        List<Block> blocks = new ArrayList<>();

        //Strip all white-spaces from the config value

        String config = pConfigList.get().replaceAll("\\s+", "");

        if (!config.isEmpty()) {
            if (config.matches("^(\\w+:\\w+,)*(\\w+:\\w+)$")) {
                String[] split = config.split(",");

                for (String entry : split) {
                    String[] splitEntry = entry.strip().split(":");
                    blocks.add(BuiltInRegistries.BLOCK.get(new ResourceLocation(splitEntry[0], splitEntry[1])));
                }
            } else {
                GlobalBlockHardnessCommon.LOGGER.error("Malformed config value! Cannot parse: [{}]", config);
            }
        }

        return blocks;
    }
}