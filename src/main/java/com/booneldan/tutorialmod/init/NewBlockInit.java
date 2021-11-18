package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.objects.blocks.CustomSaplingBlock;
import com.booneldan.tutorialmod.objects.blocks.ExampleChestBlock;
import com.booneldan.tutorialmod.objects.blocks.ModPressurePlateBlock;
import com.booneldan.tutorialmod.objects.blocks.ModWoodButtonBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class NewBlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> FIRST_DEF_BLOCK = BLOCKS.register("first_def_block", () -> new Block(AbstractBlock.Properties.of(Material.WOOD)));

    public static final RegistryObject<Block> EXAMPLE_STAIRS = BLOCKS.register("example_stairs", () -> new StairsBlock(() -> BlockInit.example_block.defaultBlockState(), AbstractBlock.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)));
    public static final RegistryObject<Block> EXAMPLE_FENCE = BLOCKS.register("example_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)));
    public static final RegistryObject<Block> EXAMPLE_BUTTON = BLOCKS.register("example_button", () -> new ModWoodButtonBlock(AbstractBlock.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)));
    public static final RegistryObject<Block> EXAMPLE_PRESSURE_PLATE = BLOCKS.register("example_pressure_plate", () -> new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)));

    public static final RegistryObject<Block> EXAMPLE_CHEST = BLOCKS.register("example_chest", () -> new ExampleChestBlock(Block.Properties.of(Material.METAL).harvestLevel(-1).instabreak().sound(SoundType.METAL).lightLevel(value -> 14)));

    public static final RegistryObject<Block> EXAMPLE_LOG = BLOCKS.register("example_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 10f).harvestLevel(0).harvestTool(ToolType.AXE)));
    public static final RegistryObject<Block> EXAMPLE_STRIPPED_LOG = BLOCKS.register("example_stripped_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2f, 3f).harvestLevel(0).harvestTool(ToolType.AXE)));

    public static final RegistryObject<Block> EXAMPLE_LEAVES = BLOCKS.register("example_leaves", () -> new LeavesBlock(AbstractBlock.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f, 1f).randomTicks().noCollission()));

    public static final RegistryObject<Block> EXAMPLE_SAPLING = BLOCKS.register("example_sapling", () -> new CustomSaplingBlock(AbstractBlock.Properties.of(Material.LEAVES).sound(SoundType.GRASS).strength(0.2f, 1f).randomTicks().noCollission(), null));
}
