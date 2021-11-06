package com.booneldan.tutorialmod.client.gui;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.container.ExampleChestContainer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class ExampleChestScreen extends ContainerScreen<ExampleChestContainer> {

    private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(TutorialMod.MOD_ID, "textures/gui/example_chest.png");

    public ExampleChestScreen(ExampleChestContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
        this.leftPos = 0;
        this.topPos = 0;
        this.imageWidth = 175;
        this.imageHeight = 183;
        this.inventoryLabelX = 8;
        this.inventoryLabelY = 91;
        this.titleLabelX = 6;
        this.titleLabelY = 6;
    }




    public void render(MatrixStack matrixStack, final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack p_230450_1_, float p_230450_2_, int p_230450_3_, int p_230450_4_) {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(BACKGROUND_TEXTURE);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;
        this.blit(p_230450_1_, x, y, 0, 0, this.imageWidth, this.imageHeight);
    }


}
