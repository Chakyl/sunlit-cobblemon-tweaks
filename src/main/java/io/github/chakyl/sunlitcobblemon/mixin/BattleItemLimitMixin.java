package io.github.chakyl.sunlitcobblemon.mixin;

import com.cobblemon.mod.common.api.battles.model.PokemonBattle;
import com.cobblemon.mod.common.api.battles.model.actor.BattleActor;
import com.cobblemon.mod.common.battles.ForcePassActionResponse;
import com.cobblemon.mod.common.battles.ShowdownActionResponse;
import dev.latvian.mods.kubejs.core.WithPersistentData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(value = BattleActor.class, remap = false)
public abstract class BattleItemLimitMixin {

    @Shadow
    public abstract PokemonBattle getBattle();


    @Inject(method = "setActionResponses", at = @At("TAIL"))
    private void afterSetAction(List<ShowdownActionResponse> responses, CallbackInfo ci) {
        if (this.getBattle().isPvN()) {

            for (ShowdownActionResponse response : responses) {
                if (response instanceof ForcePassActionResponse) {
                    if ((Object) this instanceof com.cobblemon.mod.common.battles.actor.PlayerBattleActor playerBattleActor) {
                        Player player = playerBattleActor.getEntity();
                        if (player instanceof WithPersistentData persistentPlayer) {
                            CompoundTag nbt = persistentPlayer.kjs$getPersistentData();
                            String key = "bagItemsUsed";
                            int count = 1;
                            if (nbt.contains(key)) count = nbt.getInt(key) + 1;
                            nbt.putInt(key, count);
                        }
                    }
                }
            }
        }
    }
}