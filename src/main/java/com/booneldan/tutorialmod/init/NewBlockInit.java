package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.objects.blocks.ModPressurePlateBlock;
import com.booneldan.tutorialmod.objects.blocks.ModWoodButtonBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NewBlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> FIRST_DEF_BLOCK = BLOCKS.register("first_def_block", () -> new Block(AbstractBlock.Properties.of(Material.WOOD)));

    public static final RegistryObject<Block> EXAMPLE_STAIRS = BLOCKS.register("example_stairs", () -> new StairsBlock(BlockInit.example_block::defaultBlockState, AbstractBlock.Properties.of(Material.METAL)));
    public static final RegistryObject<Block> EXAMPLE_FENCE = BLOCKS.register("example_fence", () -> new FenceBlock(AbstractBlock.Properties.of(Material.METAL)));
    public static final RegistryObject<Block> EXAMPLE_BUTTON = BLOCKS.register("example_stairs", () -> new ModWoodButtonBlock(AbstractBlock.Properties.of(Material.METAL)));
    public static final RegistryObject<Block> EXAMPLE_PRESSURE_PLATE = BLOCKS.register("example_pressure_plate", () -> new ModPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.of(Material.METAL)));
}
