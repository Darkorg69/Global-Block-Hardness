package darkorg.globalblockhardness.event;

import darkorg.globalblockhardness.setup.ConfigHandler;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class BreakSpeed {
    @SubscribeEvent
    public void breakSpeed(PlayerEvent.BreakSpeed event) {
        if (ConfigHandler.globalHardnessEnabled.get()) {
            double multiplier = 1d / ConfigHandler.globalHardnessMultiplier.get();
            event.setNewSpeed((float) (event.getNewSpeed() * multiplier));
        }
    }
}
