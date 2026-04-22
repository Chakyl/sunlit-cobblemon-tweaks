package io.github.chakyl.sunlitcobblemon.registry;

import com.google.common.base.Suppliers;
import io.github.chakyl.sunlitcobblemon.SunlitCobblemon;
import io.github.chakyl.sunlitcobblemon.block.MonBoxBlock;
import io.github.chakyl.sunlitcobblemon.blockentity.MonBoxBlockEntity;
import io.github.chakyl.sunlitcobblemon.item.PocketPCItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public final class SunlitCobblemonRegistry {

    private static final String MODID = SunlitCobblemon.MODID;

    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void register() {
        BlockRegistry.register();
        BlockEntityRegistry.register();
        ItemRegistry.register();
        CreativeTabReg.register();
    }

    public static final class BlockRegistry {

        private static void register() {
            BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<Block> MON_BOX = registerWithItem("mon_box", () ->
                new MonBoxBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).sound(SoundType.METAL).noOcclusion().strength(4F, 3000.0F)));

        private static RegistryObject<Block> registerWithItem(final String name, final Supplier<Block> supplier) {
            return registerWithItem(name, supplier, ItemRegistry::registerBlockItem);
        }

        private static RegistryObject<Block> registerWithItem(final String name, final Supplier<Block> blockSupplier, final Function<RegistryObject<Block>, RegistryObject<Item>> itemSupplier) {
            final RegistryObject<Block> block = BLOCKS.register(name, blockSupplier);
            final RegistryObject<Item> item = itemSupplier.apply(block);
            return block;
        }

        private static boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
            return false;
        }
    }


    public static final class BlockEntityRegistry {
        private static void register() {
            BLOCK_ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<BlockEntityType<MonBoxBlockEntity>> MON_BOX = BLOCK_ENTITY_TYPES.register("mon_box",
                () -> BlockEntityType.Builder.of(MonBoxBlockEntity::new, BlockRegistry.MON_BOX.get()).build(null));
    }
    public static final class ItemRegistry {

        private static final List<RegistryObject<Item>> ALL_ITEMS = new ArrayList<>();

        private static void register() {
            ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<Item> POCKET_PC = register("pocket_pc", () -> new PocketPCItem(new Item.Properties().stacksTo(1)));

        /**
         * Creates a registry object for a block item and adds it to the mod creative tab
         *
         * @param block the block
         * @return the registry object
         */
        private static RegistryObject<Item> registerBlockItem(final RegistryObject<Block> block) {
            return register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
        }

        /**
         * Creates a registry object for the given item and adds it to the mod creative tab
         *
         * @param name     the registry name
         * @param supplier the item supplier
         * @return the item registry object
         */
        private static RegistryObject<Item> register(final String name, final Supplier<Item> supplier) {
            final RegistryObject<Item> item = ITEMS.register(name, supplier);
            if (!name.equals("retrieve_worker"))
                ALL_ITEMS.add(item);
            return item;
        }
    }
    public static final class CreativeTabReg {

        private static void register() {
            CREATIVE_MODE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        }

        public static final RegistryObject<CreativeModeTab> TAB = CREATIVE_MODE_TABS.register("tab", () ->
                CreativeModeTab.builder()
                        .icon(Suppliers.memoize(() -> new ItemStack(ItemRegistry.POCKET_PC.get())))
                        .title(Component.translatable("itemGroup." + SunlitCobblemon.MODID))
                        .withSearchBar()
                        .displayItems((parameters, output) ->
                                output.acceptAll(ItemRegistry.ALL_ITEMS
                                        .stream()
                                        .map(o -> new ItemStack(o.get()))
                                        .toList())
                        )
                        .build()
        );
    }

}