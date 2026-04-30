package io.github.chakyl.sunlitcobblemon.mixin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.zanckor.cobblemonrider.CobblemonRider;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject;
import dev.zanckor.cobblemonrider.config.PokemonJsonObject.MountType;
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
        pokemonJsonObject.add("Charizard", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Blastoise", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Pidgeot", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 0.7F, 0.0F))));
        pokemonJsonObject.add("Fearow", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Nidoking", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Ninetales", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));
        pokemonJsonObject.add("Arcanine", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Tentacruel", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 1.5F, 0.0F))));
        pokemonJsonObject.add("Rapidash", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 0.8F, 0.0F))));
        pokemonJsonObject.add("Magnezone", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Dodrio", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.2F, 0.0F))));
        pokemonJsonObject.add("Dewgong", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));
        pokemonJsonObject.add("Exeggutor", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 3.0F, 0.0F))));
        pokemonJsonObject.add("Tauros", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.5F, 0.0F))));
        pokemonJsonObject.add("Gyarados", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));
        pokemonJsonObject.add("Lapras", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));
        pokemonJsonObject.add("Aerodactyl", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Dragonite", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Meganium", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.8F, 0.0F))));
        pokemonJsonObject.add("Feraligatr", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Steelix", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 6.0F, 0.0F))));
        pokemonJsonObject.add("Stantler", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Swampert", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Mightyena", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Sharpedo", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Wailmer", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Camerupt", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Relicanth", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Metagross", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Staraptor", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Luxray", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Garchomp", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Yanmega", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Mamoswine", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 5.0F, 0.0F))));
        pokemonJsonObject.add("Samurott", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Stoutland", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Scolipede", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Sawsbuck", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Golurk", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 5.0F, 0.0F))));
        pokemonJsonObject.add("Bouffalant", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Avalugg", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 3.0F, 0.0F))));
        pokemonJsonObject.add("Mudsdale", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Corviknight", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 3.0F, 0.0F))));
        pokemonJsonObject.add("Wyrdeer", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Ursaluna", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Skeledirge", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 0.6F, 0.0F))));
        // Defaults stop (espathra had a typo)
        pokemonJsonObject.add("Espathra", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));

        //Presets
        // Fly
//        pokemonJsonObject.add("Staraptor", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
//        // Walk
//        pokemonJsonObject.add("Ursaluna", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
//        // Swim
//        pokemonJsonObject.add("Lapras", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));


        pokemonJsonObject.add("Talonflame", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Moltres", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Zapdos", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Articuno", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Altaria", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Hydreigon", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));
        pokemonJsonObject.add("Noivern", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Scyther", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Skarmory", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK, MountType.FLY)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));

        pokemonJsonObject.add("Revavroom", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 0.2F, 0.0F))));
        pokemonJsonObject.add("Xerneas", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.4F, 0.0F))));
        pokemonJsonObject.add("Tyrantrum", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Torterra", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Cyclizar", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Rhyhorn", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 1.0F, 0.0F))));
        pokemonJsonObject.add("Gogoat", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Groudon", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));
        pokemonJsonObject.add("Aurorus", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.WALK)), new ArrayList(Arrays.asList(0.0F, 2.0F, 0.0F))));

        pokemonJsonObject.add("Milotic", new PokemonJsonObject.PokemonConfigData(new ArrayList(List.of(MountType.SWIM)), new ArrayList(Arrays.asList(0.0F, 0.0F, 0.0F))));

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