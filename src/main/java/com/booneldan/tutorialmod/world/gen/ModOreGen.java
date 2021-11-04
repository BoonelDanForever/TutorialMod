package com.booneldan.tutorialmod.world.gen;

import com.booneldan.tutorialmod.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;


public class ModOreGen {

    public static void generateOres(final BiomeLoadingEvent event) {
        if(!(event.getCategory().equals(Biome.Category.NETHER) && event.getCategory().equals(Biome.Category.THEEND))) {
            genOre(event.getGeneration(), OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.example_ore.getBlock().defaultBlockState(), 10, 5, 100, 13);
        }
    }

    private static void genOre(BiomeGenerationSettingsBuilder settings, RuleTest fillerType, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        settings.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.configured(new OreFeatureConfig(fillerType, state, veinSize)).decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight))).squared().count(amount));
    }
}
