package io.github.chakyl.sunlitcobblemon.mixin;


import dev.zanckor.cobblemonrider.config.PokemonJsonObject;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject.MountType;
import io.github.chakyl.sunlitcobblemon.util.IPokemonConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.List;

@Mixin(PokemonJsonObject.PokemonConfigData.class)
public abstract class PokemonConfigDataMixin implements IPokemonConfig {

    @Shadow private int stamina;
    @Shadow private float speedModifier;

    @Override
    public void setExtraStats(int stamina, float speedModifier) {
        this.stamina = stamina;
        this.speedModifier = speedModifier;
    }

}