package darkorg.globalblockhardness;

import darkorg.globalblockhardness.setup.ConfigHandler;
import darkorg.globalblockhardness.setup.EventHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GlobalBlockHardness.MOD_ID)
public class GlobalBlockHardness {

    public static final String MOD_ID = "globalblockhardness";
    IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

    public GlobalBlockHardness() {
        ConfigHandler.init();
        EventHandler.init();
        bus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
