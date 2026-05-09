package io.github.chakyl.sunlitcobblemon.events;

import com.cobblemon.mod.common.api.Priority;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.api.events.CobblemonEvents;
import com.cobblemon.mod.common.api.events.battles.BattleVictoryEvent;
import com.cobblemon.mod.common.api.events.drops.LootDroppedEvent;
import com.cobblemon.mod.common.battles.pokemon.BattlePokemon;
import com.rafacasari.mod.cobbledex.Cobbledex;
import com.rafacasari.mod.cobbledex.api.classes.DiscoveryRegister;
import kotlin.Unit;
import net.minecraft.server.level.ServerPlayer;

import java.util.List;


public class SunlitCobblemonEvents {
    public void eventInit() {
        com.cobblemon.mod.common.api.events.CobblemonEvents.BATTLE_VICTORY.subscribe(Priority.LOWEST, this::pokemonBattleVictory);
        CobblemonEvents.LOOT_DROPPED.subscribe(Priority.LOWEST, this::lootDropped);
    }

    private Unit pokemonBattleVictory(BattleVictoryEvent battleVictoryEvent) {

        List<ServerPlayer> players = battleVictoryEvent.getBattle().getPlayers();
        if (players.size() != 1) return Unit.INSTANCE;

        ServerPlayer player = players.get(0);

        Iterable<BattleActor> battleActors = battleVictoryEvent.getBattle().getActors();
        for (BattleActor actor : battleActors) {
            if (actor != battleVictoryEvent.getWinners().get(0)) {
                for (BattlePokemon pokemon : actor.getPokemonList()) {
                    Cobbledex.INSTANCE.registerPlayerDiscovery(player, pokemon.getOriginalPokemon().getForm(), pokemon.getOriginalPokemon().getShiny(), DiscoveryRegister.RegisterType.SEEN);
                }
            }
        }
        return Unit.INSTANCE;
    }

    private Unit lootDropped(LootDroppedEvent lootDroppedEvent) {
        if (lootDroppedEvent.getPlayer() != null) {
            lootDroppedEvent.cancel();
        }
        return Unit.INSTANCE;
    }
}