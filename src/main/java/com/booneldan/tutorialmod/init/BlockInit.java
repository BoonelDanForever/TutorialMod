package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class BlockInit {

    public static final Block example_block = null;
    public static final Block example_ore = null;
    public static final Block quarry = null;


    @SubscribeEvent
    public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new Block(Block.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)).setRegistryName("example_block"));
        event.getRegistry().register(new Block(Block.Properties.of(Material.STONE).harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)).setRegistryName("example_ore"));
        event.getRegistry().register(new Block(Block.Properties.of(Material.METAL)).setRegistryName("quarry"));
    }

    @SubscribeEvent
    public static void RegisterBlockItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new BlockItem(example_block, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_block"));
        event.getRegistry().register(new BlockItem(example_ore, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_ore"));
        event.getRegistry().register(new BlockItem(quarry, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("quarry"));

    }
}
