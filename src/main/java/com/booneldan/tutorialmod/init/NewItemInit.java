package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class NewItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> FIRST_DEF_ITEM = ITEMS.register("first_def_item", () -> new Item(new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).stacksTo(32)));
}