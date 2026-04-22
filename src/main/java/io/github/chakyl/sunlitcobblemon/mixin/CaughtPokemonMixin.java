package io.github.chakyl.sunlitcobblemon.mixin;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.rafacasari.mod.cobbledex.CobbledexConstants;
import com.rafacasari.mod.cobbledex.api.classes.DiscoveryRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(Pokemon.class)
public abstract class CaughtPokemonMixin {

    private Pokemon self() {
        return (Pokemon) (Object) this;
    }

    @Inject(method = "getDisplayName", at = {@At("RETURN")}, cancellable = true, remap = false)
    private void modifyPokemonName(CallbackInfoReturnable<MutableComponent> cir) {
        Pokemon pokemon = self();
        if (!pokemon.isWild() || pokemon.getEntity() != null && pokemon.getEntity().isBattling()) return;
        if (pokemon.getOriginalTrainer() == null || pokemon.getOriginalTrainer().equals("NONE")) {
            Component name = cir.getReturnValue();
            MutableComponent iconName = Component.literal(name.getString());
            switch (getPokeDexState(pokemon)) {
                case "SHINY_CAUGHT" -> {
                    MutableComponent caughtIcon = Component.literal("◇ ");
                    caughtIcon.append(iconName);
                    iconName = caughtIcon.copy();
                }
                case "CAUGHT" -> {
                    MutableComponent caughtIcon = Component.literal("◆ ");
                    caughtIcon.append(iconName);
                    iconName = caughtIcon.copy();
                }
                case "UNKNOWN" -> iconName = Component.translatable("gui.sunlit_cobblemon.unknown_pokemon");
                case "SEEN" -> cir.setReturnValue(Component.literal(name.getString()));
            }
            cir.setReturnValue(iconName);
        }
    }

    private String getPokeDexState(Pokemon pokemon) {
        if (pokemon == null) return "UNKNOWN";
        Map<String, Map<String, DiscoveryRegister>> discoveredList = CobbledexConstants.Client.INSTANCE.getDiscoveredList();
        Map<String, DiscoveryRegister> speciesList = discoveredList.get(pokemon.getSpecies().showdownId());
        if (speciesList == null) return "UNKNOWN";
        DiscoveryRegister register = speciesList.get(pokemon.getForm().formOnlyShowdownId());
        if (register == null) return "UNKNOWN";
        if (register.isShiny() && register.getStatus() == DiscoveryRegister.RegisterType.CAUGHT) return "SHINY_CAUGHT";
        if (register.getStatus() == DiscoveryRegister.RegisterType.CAUGHT) return "CAUGHT";
        if (register.getStatus() == DiscoveryRegister.RegisterType.SEEN) return "SEEN";
        return "UNKNOWN";
    }

}
