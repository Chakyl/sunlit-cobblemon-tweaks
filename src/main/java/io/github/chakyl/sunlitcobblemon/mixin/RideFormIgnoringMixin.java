package io.github.chakyl.sunlitcobblemon.mixin;

import dev.zanckor.cobblemonrider.MCUtil;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = MCUtil.class, remap = false)
public class RideFormIgnoringMixin {

    @ModifyVariable(
            method = "getPassengerObject(Ljava/lang/String;Ljava/lang/String;)Ldev/zanckor/cobblemonrider/config/PokemonJsonObject$PokemonConfigData;",
            at = @At(value = "STORE", ordinal = 0),
            name = "isSameForm"
    )
    private static boolean forceSameForm(boolean original) {
        return true;
    }
}