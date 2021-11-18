package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import com.booneldan.tutorialmod.entity.ExampleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypesInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE = ENTITY_TYPES.register("example", () -> EntityType.Builder.of(ExampleEntity::new, EntityClassification.MONSTER).sized(1.0f, 1.0f).build(new ResourceLocation(TutorialMod.MOD_ID, "example").toString()));
}
