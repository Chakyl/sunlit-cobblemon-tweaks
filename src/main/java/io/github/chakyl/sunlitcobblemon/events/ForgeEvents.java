package io.github.chakyl.sunlitcobblemon.events;

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.rafacasari.mod.cobbledex.Cobbledex;
import com.rafacasari.mod.cobbledex.api.CobbledexDiscovery;
import com.rafacasari.mod.cobbledex.api.classes.DiscoveryRegister;
import io.github.chakyl.sunlitcobblemon.SunlitCobblemon;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SunlitCobblemon.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (event.getLevel().isClientSide) return;
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        Player player = event.getEntity();
        if (event.getTarget() != null && event.getTarget() instanceof PokemonEntity pokemonEntity) {
            Pokemon pokemon = pokemonEntity.getPokemon();
            if (pokemon.belongsTo(player) && !CobbledexDiscovery.Companion.getPlayerData((ServerPlayer) player).caught(pokemonEntity.getForm())) {
                CobbledexDiscovery.Companion.getPlayerData((ServerPlayer) player).addOrUpdate((ServerPlayer) player, pokemonEntity.getForm(), pokemon.getShiny(), DiscoveryRegister.RegisterType.CAUGHT, null, true);
                player.sendSystemMessage(Component.translatable("cobbledex.texts.new_pokemon_discovered", Component.literal(pokemonEntity.getForm().species.getName()).withStyle(ChatFormatting.GREEN).withStyle(ChatFormatting.BOLD)));
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }
    }
}