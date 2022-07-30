package darkorg.globalblockhardness.setup;

import darkorg.globalblockhardness.event.BreakSpeed;
import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
    public static void init() {
        MinecraftForge.EVENT_BUS.register(new BreakSpeed());
    }
}
