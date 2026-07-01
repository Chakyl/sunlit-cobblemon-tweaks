package io.github.chakyl.sunlitcobblemon.mixin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.zanckor.cobblemonrider.CobblemonRider;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject.MountType;
import io.github.chakyl.sunlitcobblemon.util.IPokemonConfig;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(CobblemonRider.FolderManager.class)
public class RiderPokemonMixin {

    /**
     * @author Chakyl
     * @reason Overriding ridable pokemon
     */
    @SubscribeEvent
    @Overwrite(remap = false)
    public static void serverFolderManager(ServerAboutToStartEvent e) {
        Path serverDirectory = e.getServer().getWorldPath(LevelResource.ROOT).toAbsolutePath();
        File pokemonRideConfig = Paths.get(serverDirectory.toString(), "serverconfig" + FileSystems.getDefault().getSeparator() + "pokemonRideConfig.json").toFile();
        CobblemonRider.PokemonRideConfigFile = pokemonRideConfig;
        PokemonJsonObject pokemonJsonObject = new PokemonJsonObject();

        //Presets
        // Fly
//        pokemonJsonObject.add("Staraptor", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
//        // Walk
//        pokemonJsonObject.add("Ursaluna", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
//        // Swim
//        pokemonJsonObject.add("Lapras", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));

        pokemonJsonObject.add("Nidoking", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Nidoqueen", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Talonflame", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.3F, 0.0F))), 400, 1.2F));
        pokemonJsonObject.add("Moltres", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.2F, 0.0F))), 300, 1.6F));
        pokemonJsonObject.add("Zapdos", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.1F, 0.0F))), 300, 1.6F));
        pokemonJsonObject.add("Articuno", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.3F, 0.0F))), 600, 1.2F));
        pokemonJsonObject.add("Altaria", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(-0.3F, 0.3F, 0.0F))), 400, 1.0F));
        pokemonJsonObject.add("Luxray", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(-0.3F, 0.7F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mamoswine", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.2F, 2.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Relicanth", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Espathra", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dragonite", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Fearow", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Garchomp", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.7F, 0.0F))), 1000, 1.45F));
        pokemonJsonObject.add("Dodrio", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.3F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Arcanine", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Steelix", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 6.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Stantler", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Avalugg", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 3.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Magnezone", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Stoutland", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mightyena", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Wailmer", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Sawsbuck", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mudsdale", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.35F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ursaluna", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.2F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Metagross", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Corviknight", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 2.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Staraptor", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Charizard", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Swampert", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rapidash", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Skeledirge", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.6F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dewgong", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Yanmega", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Xerneas", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.7F));
        pokemonJsonObject.add("Tyrantrum", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 5.0F, 0.0F))), 0, 0.5F));
        pokemonJsonObject.add("Torterra", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 0.4F));
        pokemonJsonObject.add("Tauros", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Revavroom", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.2F, 0.0F))), 0, 3.0F));
        pokemonJsonObject.add("Cyclizar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.2F));
        pokemonJsonObject.add("Aerodactyl", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Hydreigon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Noivern", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Scyther", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Sharpedo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Bouffalant", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Exeggutor", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 3.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Camerupt", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.8F));
        pokemonJsonObject.add("Rhyhorn", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.5F));
        pokemonJsonObject.add("Gogoat", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.8F));
        pokemonJsonObject.add("Amaura", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.9F));
        pokemonJsonObject.add("Aurorus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.9F));
        pokemonJsonObject.add("Scolipede", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Blastoise", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lapras", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Milotic", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Skarmory", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Wyrdeer", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 1.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Gyarados", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ninetales", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Samurott", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tentacruel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 1.5F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Meganium", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Groudon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 0.6F));
        pokemonJsonObject.add("Feraligatr", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Golurk", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 5.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Pidgeot", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.7F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Archeops", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tropius", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dragapult", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.5F));
        pokemonJsonObject.add("Noctowl", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kilowattrel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.5F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zebtsrika", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Venusaur", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Beedrill", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(-0.3F, 0.4F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Parasect", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Machamp", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Onix", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rhydon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Snorlax", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 0.75F));
        pokemonJsonObject.add("Ariados", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Heracross", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Houndoom", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lugia", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("HoOh", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Swellow", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Pelipper", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Slaking", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 0.1F));
        pokemonJsonObject.add("Lairon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Aggron", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Manectric", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Torkoal", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 0.5F));
        pokemonJsonObject.add("Flygon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Whiscash", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Crawdaunt", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Armaldo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Absol", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.25F));
        pokemonJsonObject.add("Walrein", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Salamence", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 1.3F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Latias", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Latios", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rayquaza", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kyogre", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Gastrodon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Honchkrow", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Hippowdon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Drapion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Electivire", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rhyperior", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Togekiss", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dialga", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Palkia", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Giratina", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Arceus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 2.0F));
        pokemonJsonObject.add("Liepard", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Unfezant", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Gigalith", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Galvantula", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.5F));
        pokemonJsonObject.add("Haxorus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 2.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Braviary", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Volcarona", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(1.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Cobalion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Terrakion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Virizion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tornadus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Thundurus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Reshiram", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zekrom", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Landorus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kyurem", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Chesnaught", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Furfrou", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dragalge", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Goodra", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Yveltal", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Volcanion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Vikavolt", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lycanroc", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Golisopod", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("TypeNull", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Silvally", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Drampa", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kommoo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Solgaleo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lunala", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rillaboom", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dubwool", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Drednaw", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Copperajah", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zacian", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zamazenta", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Glastrier", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Spectrier", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Basculegion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Oinkologne", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mabosstiff", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Toedscruel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Palafin", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Orthworm", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Houndstone", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Dondozo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Koraidon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Arbok", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Starmie", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.8F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Typhlosion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lanturn", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Gliscor", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mantine", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Miraidon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kingdra", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Donphan", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Raikou", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Entei", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Suicune", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tyranitar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lugia", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("HoOh", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Blaziken", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Sceptile", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Swampert", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Linoone", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Shiftry", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Pelipper", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Carvanha", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Wailord", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Seviper", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Regirock", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Regice", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Registeel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Infernape", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Empoleon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Bibarel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Rampardos", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Bastiodon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Floatzel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Skuntank", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Bronzong", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tangrowth", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Magmortar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Heatran", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Cresselia", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Regigigas", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 0.1F));
        pokemonJsonObject.add("Serperior", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Emboar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Samurott", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zebstrika", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.5F));
        pokemonJsonObject.add("Excadrill", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Seismitoad", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Krookodile", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Darmanitan", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Carracosta", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 0.5F));
        pokemonJsonObject.add("Zoroark", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Swanna", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Escavalier", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.5F));
        pokemonJsonObject.add("Jellicent", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Druddigon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Mandibuzz", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Cobalion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Terrakion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Virizion", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Tornadus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Thundurus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Landorus", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Reshiram", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zekrom", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Kyurem", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Diggersby", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Pyroar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Pangoro", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Decidueye", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Primarina", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Incineroar", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Toucannon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Araquanid", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("TapuKoko", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("TapuLele", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("TapuBuluo", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("TapuFini", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Buzzwole", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Celesteela", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Necrozma", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Naganadel", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Melmetal", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Zeraora", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 2.0F));
        pokemonJsonObject.add("Cinderace", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Thievul", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Boltund", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.5F));
        pokemonJsonObject.add("Flapple", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Appletun", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Centiskorch", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Regieleki", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 2.0F));
        pokemonJsonObject.add("Regidrago", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Meowscarada", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Quaquaval", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Lokix", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Klawf", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Greattusk", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Slitherwing", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Irontreads", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironmoth", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironjugulis", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironthorns", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Baxcalibur", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Roaringmoon", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.FLY)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Walkingwake", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK, MountType.SWIM)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironleaves", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Fezandipiti", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Gougingfire", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ragingbolt", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironboulder", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));
        pokemonJsonObject.add("Ironcrown", IPokemonConfig.apply(new PokemonJsonObject.PokemonConfigData(new ArrayList<>(List.of(MountType.WALK)), new ArrayList<>(List.of(0.0F, 0.0F, 0.0F))), 0, 1.0F));

        if (pokemonRideConfig.exists()) {
            boolean deleted = pokemonRideConfig.delete();
            if (deleted) {
                CobblemonRider.LOGGER.info("Deleted existing config file at " + pokemonRideConfig);
            } else {
                CobblemonRider.LOGGER.warn("Failed to delete existing config file at " + pokemonRideConfig);
            }
        }

        try (FileWriter file = new FileWriter(pokemonRideConfig)) {
            file.write((new GsonBuilder()).setPrettyPrinting().create().toJson(pokemonJsonObject));
            CobblemonRider.LOGGER.info("File created: " + pokemonRideConfig.getName());
            CobblemonRider.LOGGER.info("Cobblemon pokemon ride config file created at " + pokemonRideConfig);
        } catch (IOException ex) {
            ex.printStackTrace();
            CobblemonRider.LOGGER.error("Error creating cobblemon pokemon ride config file: " + pokemonRideConfig);
        }

        try {
            String pokemonRideConfigObject = new String(Files.readAllBytes(pokemonRideConfig.toPath()));
            CobblemonRider.pokemonJsonObject = (PokemonJsonObject)(new Gson()).fromJson(pokemonRideConfigObject, PokemonJsonObject.class);
        } catch (IOException var7) {
            CobblemonRider.LOGGER.info("Error reading cobblemon pokemon ride config file" + pokemonRideConfig);
        }
    }
}
