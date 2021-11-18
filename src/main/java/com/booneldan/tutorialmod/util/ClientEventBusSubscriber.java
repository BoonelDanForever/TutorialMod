package com.booneldan.tutorialmod.util;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.client.entity.ExampleEntityRenderer;
import com.booneldan.tutorialmod.client.gui.ExampleChestScreen;
import com.booneldan.tutorialmod.init.EntityTypesInit;
import com.booneldan.tutorialmod.init.ModContainerTypes;
import com.booneldan.tutorialmod.init.NewBlockInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.register(ModContainerTypes.EXAMPLE_CHEST.get(), ExampleChestScreen::new);

		RenderTypeLookup.setRenderLayer(NewBlockInit.EXAMPLE_LEAVES.get(), RenderType.cutout());
		RenderTypeLookup.setRenderLayer(NewBlockInit.EXAMPLE_SAPLING.get(), RenderType.cutout());

		RenderingRegistry.registerEntityRenderingHandler(EntityTypesInit.EXAMPLE.get(), ExampleEntityRenderer::new);
	}
}
