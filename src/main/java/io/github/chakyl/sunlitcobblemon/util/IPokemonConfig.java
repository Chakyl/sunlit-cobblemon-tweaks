package io.github.chakyl.sunlitcobblemon.util;

import dev.zanckor.cobblemonrider.config.PokemonJsonObject;
import io.github.chakyl.sunlitcobblemon.SunlitCobblemon;

public interface IPokemonConfig {
    void setExtraStats(int stamina, float speedModifier);
    static PokemonJsonObject.PokemonConfigData apply(PokemonJsonObject.PokemonConfigData data, int stamina, float speed) {
        SunlitCobblemon.LOGGER.info("setting stamina to " + stamina);
        ((IPokemonConfig) data).setExtraStats(stamina, speed);
        return data;
    }
}