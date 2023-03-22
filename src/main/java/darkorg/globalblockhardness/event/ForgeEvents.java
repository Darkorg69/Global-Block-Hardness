package darkorg.globalblockhardness.event;

import darkorg.globalblockhardness.GlobalBlockHardness;
import darkorg.globalblockhardness.config.ModConfig;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GlobalBlockHardness.MOD_ID)
public class ForgeEvents {
    @SubscribeEvent
    public static void onBreakSpeed(PlayerEvent.BreakSpeed event) {
        event.setNewSpeed(event.getNewSpeed() / ModConfig.SERVER.globalBlockHardnessMultiplier.get().floatValue());
    }
}