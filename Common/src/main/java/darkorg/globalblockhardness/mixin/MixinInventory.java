package darkorg.globalblockhardness.mixin;

import darkorg.globalblockhardness.config.GlobalBlockHardnessConfig;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Inventory.class)
public class MixinInventory {
    @Inject(at = @At("TAIL"), method = {"getDestroySpeed"}, cancellable = true)
    public void getDestroySpeed(BlockState pBlockState, CallbackInfoReturnable<Float> pReturn) {
        Block block = pBlockState.getBlock();

        // Check if block should be overridden
        if (GlobalBlockHardnessConfig.override.containsKey(block)) {
            pReturn.setReturnValue(pReturn.getReturnValue() / GlobalBlockHardnessConfig.override.get(block));
            return;
        }

        // Check if whitelist is enabled
        if (GlobalBlockHardnessConfig.SERVER.whitelistEnabled.get()) {
            // Apply global settings only if block is in whitelist
            if (!GlobalBlockHardnessConfig.whitelist.contains(block)) {
                return; // Skip modifying block's hardness
            }
        } else {
            // Apply global settings only if block is not in blacklist
            if (GlobalBlockHardnessConfig.blacklist.contains(block)) {
                return; // Skip modifying block's hardness
            }
        }

        // Apply global settings
        pReturn.setReturnValue(pReturn.getReturnValue() / GlobalBlockHardnessConfig.SERVER.blockHardnessMultiplier.get().floatValue());
    }
}
