package io.github.chakyl.sunlitcobblemon.mixin;


import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.reactive.ObservableSubscription;
import com.cobblemon.mod.common.api.storage.NoPokemonStoreException;
import com.cobblemon.mod.common.api.storage.party.PlayerPartyStore;
import kotlin.Unit;
import ludichat.cobbreeding.Cobbreeding;
import ludichat.cobbreeding.IncubatorAbilitiesRegistry;
import net.minecraft.server.level.ServerPlayer;
import org.apache.commons.lang3.tuple.MutablePair;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.Map;

@Mixin(value = IncubatorAbilitiesRegistry.class, remap = false)
public abstract class IncubatorAbilitiesRegistryMixin {

    @Shadow @Final
    private Map<String, MutablePair<ObservableSubscription<Unit>, Boolean>> registry;

    @Shadow
    public abstract boolean isIncubator(PlayerPartyStore party);

    /**
     * @author Chakyl
     * @reason Fix NPE
     */
    @Overwrite
    public void update(ServerPlayer player) {
        String uuid = player.getUUID().toString();

        if (registry.get(uuid) == null) {
            Cobbreeding.LOGGER.warn(player.getName().getString() + " can't be found in Incubator Ability Registry.");
            return;
        }

        try {
            PlayerPartyStore party = Cobblemon.INSTANCE.getStorage().getParty(player.getUUID());
            registry.get(uuid).setRight(isIncubator(party));
        } catch (NoPokemonStoreException e) {
            Cobbreeding.LOGGER.error("Could not update incubator status: No storage found for player " + player.getName().getString());
        }
    }

    /**
     * @author Chakyl
     * @reason Fix NPE
     */
    @Overwrite
    public void remove(ServerPlayer player) {
        String uuid = player.getUUID().toString();
        MutablePair<ObservableSubscription<Unit>, Boolean> entry = registry.get(uuid);
        if (entry != null) {
            entry.getLeft().unsubscribe();
            registry.remove(uuid);
        }
    }
}