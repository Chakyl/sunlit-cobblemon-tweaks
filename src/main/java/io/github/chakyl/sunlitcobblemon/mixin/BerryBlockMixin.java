package io.github.chakyl.sunlitcobblemon.mixin;

import com.cobblemon.mod.common.block.BerryBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BerryBlock.class)
public abstract class BerryBlockMixin {

    @Inject(method = "performBonemeal", at = @At("HEAD"), cancellable = true)
    private void preventGrowthOnDryFarmland(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, CallbackInfo ci) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (belowState.getBlock() instanceof FarmBlock) {
            int moisture = belowState.getValue(FarmBlock.MOISTURE);
            if (moisture <= 0) {
                ci.cancel();
            }
        }
    }
}