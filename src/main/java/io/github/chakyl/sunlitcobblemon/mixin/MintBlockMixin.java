package io.github.chakyl.sunlitcobblemon.mixin;

import com.cobblemon.mod.common.block.MintBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MintBlock.class)
public abstract class MintBlockMixin {

    @Unique
    private static final TagKey<Block> WATERABLE = TagKey.create(Registries.BLOCK, new ResourceLocation("dewdrop", "waterable"));

    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true, remap = true)
    private void canSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState floor = level.getBlockState(pos.below());
        boolean hasEnoughLight = level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos);

        if (hasEnoughLight) {
            if (floor.is(WATERABLE)) {
                cir.setReturnValue(true);
            }
        }
    }
}