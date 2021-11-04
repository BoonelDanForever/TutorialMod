package com.booneldan.tutorialmod.init;

import com.booneldan.tutorialmod.TutorialMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;



@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {

    // Items
    public static final Item example_item = null;
    public static final Item test_item = null;
    public static final Item special_item = null;

    // Tools
    public static final Item example_sword = null;
    public static final Item example_pickaxe = null;
    public static final Item example_axe = null;
    public static final Item example_shovel= null;
    public static final Item example_hoe = null;

    // Tools
    public static final Item example_helmet = null;
    public static final Item example_chestplate = null;
    public static final Item example_leggings = null;
    public static final Item example_boots = null;




    @SubscribeEvent
    public static void RegisterItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item(new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_item"));
        event.getRegistry().register(new Item(new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).food(new Food.Builder().nutrition(7).saturationMod(1.3F).alwaysEat().meat().effect(new EffectInstance(Effects.GLOWING, 6000, 1), 1F).build())).setRegistryName("test_item"));

        // Tools
        event.getRegistry().register(new SwordItem(ModItemTier.EXAMPLE, 7, 5.0F, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).fireResistant()).setRegistryName("example_sword"));
        event.getRegistry().register(new PickaxeItem(ModItemTier.EXAMPLE, 4, 5.0F, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).addToolType(ToolType.PICKAXE, 5).fireResistant()).setRegistryName("example_pickaxe"));
        event.getRegistry().register(new AxeItem(ModItemTier.EXAMPLE, 11, 3.0F, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).addToolType(ToolType.AXE, 5).fireResistant()).setRegistryName("example_axe"));
        event.getRegistry().register(new ShovelItem(ModItemTier.EXAMPLE, 2, 5.0F, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).addToolType(ToolType.SHOVEL, 5).fireResistant()).setRegistryName("example_shovel"));
        event.getRegistry().register(new HoeItem(ModItemTier.EXAMPLE, 15, 1.0F, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance).addToolType(ToolType.HOE, 5).fireResistant()).setRegistryName("example_hoe"));

        // Armor
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.HEAD, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.CHEST, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.LEGS, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.EXAMPLE, EquipmentSlotType.FEET, new Item.Properties().tab(TutorialMod.TutorialItemGroup.instance)).setRegistryName("example_boots"));

    }

    public enum ModItemTier implements IItemTier {
        EXAMPLE(5,1536, 15.0F, 7.0F, 250, () -> {
            return Ingredient.of(ItemInit.example_item);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getUses() {
            return this.maxUses;
        }

        @Override
        public float getSpeed() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamageBonus() {
            return this.attackDamage;
        }

        @Override
        public int getLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantmentValue() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairMaterial.get();
        }
    }

    public enum ModArmorMaterial implements IArmorMaterial {
        EXAMPLE(TutorialMod.MOD_ID + ":example", 5, new int[] {7, 9, 11, 7}, 420, SoundEvents.ARMOR_EQUIP_IRON, 6.9F, () -> {
            return Ingredient.of(ItemInit.example_item);
        }, 0.69F);

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;
        private final float knockbackResistance;

        private ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResistance) {
            this.name = name;
            this.maxDamageFactor = maxDamageFactor;
            this.damageReductionAmountArray = damageReductionAmmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.toughness = toughness;
            this.repairMaterial = new LazyValue<>(repairMaterial);
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurabilityForSlot(EquipmentSlotType slotIn) {
            return this.MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDefenseForSlot(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return enchantability;
        }

        @Override
        public SoundEvent getEquipSound() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return this.repairMaterial.get();
        }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return this.knockbackResistance;
        }
    }
}

