package com.booneldan.tutorialmod;

import com.booneldan.tutorialmod.init.BlockInit;
import com.booneldan.tutorialmod.init.ModTileEntityTypes;
import com.booneldan.tutorialmod.init.NewBlockInit;
import com.booneldan.tutorialmod.init.NewItemInit;
import com.booneldan.tutorialmod.world.gen.ModOreGen;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tutorialmod")
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TutorialMod  {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tutorialmod";
    public static TutorialMod instance;


    public TutorialMod() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        NewItemInit.ITEMS.register(modEventBus);
        NewBlockInit.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        instance = this;
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
         final IForgeRegistry<Item> registry = event.getRegistry();
         NewBlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
             final Item.Properties properties = new Item.Properties().tab(TutorialItemGroup.instance);
             final BlockItem blockItem = new BlockItem(block, properties);
             blockItem.setRegistryName(block.getRegistryName());
             registry.register(blockItem);
        });
         LOGGER.debug("Registered BlockItems!");
    }

    private void setup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, ModOreGen::generateOres);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {}


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {}

    public static class TutorialItemGroup extends ItemGroup {

        public static final TutorialItemGroup instance = new TutorialItemGroup(ItemGroup.TABS.length, "tutorialtab");
        private TutorialItemGroup(int index, String label) {
            super(index, label);
        }

        @Override
        public ItemStack makeIcon() {
            return new ItemStack(BlockInit.example_block);
        }
    }
}
