package io.github.chakyl.sunlitcobblemon;

import com.mojang.logging.LogUtils;
import io.github.chakyl.sunlitcobblemon.events.ForgeEvents;
import io.github.chakyl.sunlitcobblemon.events.SunlitCobblemonEvents;
import io.github.chakyl.sunlitcobblemon.registry.SunlitCobblemonRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

@Mod(SunlitCobblemon.MODID)
public class SunlitCobblemon {
    public static final String MODID = "sunlit_cobblemon";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static boolean GROWTH_EDITION_INSTALLED = false;
    public static final SimpleChannel CHANNEL = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(MODID, MODID))
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .networkProtocolVersion(() -> "1.0.0")
            .simpleChannel();


    public SunlitCobblemon() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        SunlitCobblemonRegistry.register();
        new SunlitCobblemonEvents().eventInit();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(ForgeEvents.class);

    }
}