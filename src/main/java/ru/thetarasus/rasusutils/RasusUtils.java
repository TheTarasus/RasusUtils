package ru.thetarasus.rasusutils;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.impl.registry.sync.FabricRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import ru.thetarasus.rasusutils.horse.BobberEnchantment;
import ru.thetarasus.rasusutils.horse.PatienceEnchantment;
import ru.thetarasus.rasusutils.horse.ToughnessEnchantment;
import ru.thetarasus.rasusutils.item.*;

public class RasusUtils implements ModInitializer  {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static String MOD_ID = "rasusutils";

	public static Item LOGO_ITEM = new Item(new FabricItemSettings());
	public static ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID), () -> new ItemStack(LOGO_ITEM)).setName("RasusUtils");

	public static Item FUR = new Item(new FabricItemSettings().group(ITEM_GROUP));
	public static Item WOLF_MEAT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().meat().hunger(2).saturationModifier(1.5f).build()).group(ITEM_GROUP));
	public static StatusEffectInstance regen = new StatusEffectInstance(StatusEffects.REGENERATION, 60);
	public static Item COOKED_WOLF_MEAT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().meat().hunger(7).saturationModifier(7f).statusEffect(regen, 0.5f).build()).group(ITEM_GROUP));
	public static ArmorItem FUR_USHANKA = new FurArmor(RasusArmorMaterials.FUR, EquipmentSlot.HEAD, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem FUR_COAT = new FurArmor(RasusArmorMaterials.FUR, EquipmentSlot.CHEST, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem FUR_PANTS = new FurArmor(RasusArmorMaterials.FUR, EquipmentSlot.LEGS, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem VALENKI = new FurArmor(RasusArmorMaterials.FUR, EquipmentSlot.FEET, new FabricItemSettings().group(ITEM_GROUP));


	public static ArmorItem PANAMA_HAT = new LightweightArmor(RasusArmorMaterials.LIGHTWEIGHT, EquipmentSlot.HEAD, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem T_SHIRT = new LightweightArmor(RasusArmorMaterials.LIGHTWEIGHT, EquipmentSlot.CHEST, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem LIGHTWEIGHT_SHORTS = new LightweightArmor(RasusArmorMaterials.LIGHTWEIGHT, EquipmentSlot.LEGS, new FabricItemSettings().group(ITEM_GROUP));
	public static ArmorItem SNEAKERS = new LightweightArmor(RasusArmorMaterials.LIGHTWEIGHT, EquipmentSlot.FEET, new FabricItemSettings().group(ITEM_GROUP));

	public static BrassPickaxeItem BRASS_PICKAXE = new BrassPickaxeItem(new BrassToolMaterial(), -1, -2.0F, new FabricItemSettings().group(ITEM_GROUP));
	public static BrassAxeItem BRASS_AXE = new BrassAxeItem(new BrassToolMaterial(), 6.0F, -3.1F, new FabricItemSettings().group(ITEM_GROUP));
	public static BrassShovelItem BRASS_SHOVEL = new BrassShovelItem(new BrassToolMaterial(), -1, -2.0F, new FabricItemSettings().group(ITEM_GROUP));
	public static BrassHoeItem BRASS_HOE = new BrassHoeItem(new BrassToolMaterial(), -2, -1.0F, new FabricItemSettings().group(ITEM_GROUP));
	public static BrassSwordItem BRASS_SWORD = new BrassSwordItem(new BrassToolMaterial(), 3, -2.4F, new FabricItemSettings().group(ITEM_GROUP));

	public static LandmineBlock LANDMINE_BLOCK = new LandmineBlock(AbstractBlock.Settings.of(Material.WOOL).noCollision().dynamicBounds().hardness(1f));
	public static BlockItem LANDMINE_ITEM = new BlockItem(LANDMINE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static Item PARTIALLY_ASSEMBLED_LANDMINE = new Item(new FabricItemSettings());


	public static Block WHITE_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block ORANGE_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block MAGENTA_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block LIGHT_BLUE_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block YELLOW_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block LIME_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block PINK_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block GRAY_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block LIGHT_GRAY_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block CYAN_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block PURPLE_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block BLUE_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block BROWN_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block GREEN_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block RED_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());
	public static Block BLACK_ARMORED_CONCRETE_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).hardness(50f).resistance(1200f).requiresTool());


	public static Block WHITE_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block ORANGE_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block MAGENTA_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block LIGHT_BLUE_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block YELLOW_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block LIME_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block PINK_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block GRAY_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block LIGHT_GRAY_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block CYAN_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block PURPLE_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block BLUE_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block BROWN_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block GREEN_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block RED_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());
	public static Block BLACK_ARMORED_METAL_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL).hardness(95f).resistance(1200f).requiresTool());

	public static BlockItem WHITE_ARMORED_CONCRETE_ITEM = new BlockItem(WHITE_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem ORANGE_ARMORED_CONCRETE_ITEM = new BlockItem(ORANGE_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem MAGENTA_ARMORED_CONCRETE_ITEM = new BlockItem(MAGENTA_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIGHT_BLUE_ARMORED_CONCRETE_ITEM = new BlockItem(LIGHT_BLUE_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem YELLOW_ARMORED_CONCRETE_ITEM = new BlockItem(YELLOW_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIME_ARMORED_CONCRETE_ITEM = new BlockItem(LIME_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem PINK_ARMORED_CONCRETE_ITEM = new BlockItem(PINK_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem GRAY_ARMORED_CONCRETE_ITEM = new BlockItem(GRAY_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIGHT_GRAY_ARMORED_CONCRETE_ITEM = new BlockItem(LIGHT_GRAY_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem CYAN_ARMORED_CONCRETE_ITEM = new BlockItem(CYAN_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem PURPLE_ARMORED_CONCRETE_ITEM = new BlockItem(PURPLE_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BLUE_ARMORED_CONCRETE_ITEM = new BlockItem(BLUE_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BROWN_ARMORED_CONCRETE_ITEM = new BlockItem(BROWN_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem GREEN_ARMORED_CONCRETE_ITEM = new BlockItem(GREEN_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem RED_ARMORED_CONCRETE_ITEM = new BlockItem(RED_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BLACK_ARMORED_CONCRETE_ITEM = new BlockItem(BLACK_ARMORED_CONCRETE_BLOCK, new FabricItemSettings().group(ITEM_GROUP));

	public static BlockItem WHITE_ARMORED_METAL_ITEM = new BlockItem(WHITE_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem ORANGE_ARMORED_METAL_ITEM = new BlockItem(ORANGE_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem MAGENTA_ARMORED_METAL_ITEM = new BlockItem(MAGENTA_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIGHT_BLUE_ARMORED_METAL_ITEM = new BlockItem(LIGHT_BLUE_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem YELLOW_ARMORED_METAL_ITEM = new BlockItem(YELLOW_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIME_ARMORED_METAL_ITEM = new BlockItem(LIME_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem PINK_ARMORED_METAL_ITEM = new BlockItem(PINK_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem GRAY_ARMORED_METAL_ITEM = new BlockItem(GRAY_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem LIGHT_GRAY_ARMORED_METAL_ITEM = new BlockItem(LIGHT_GRAY_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem CYAN_ARMORED_METAL_ITEM = new BlockItem(CYAN_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem PURPLE_ARMORED_METAL_ITEM = new BlockItem(PURPLE_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BLUE_ARMORED_METAL_ITEM = new BlockItem(BLUE_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BROWN_ARMORED_METAL_ITEM = new BlockItem(BROWN_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem GREEN_ARMORED_METAL_ITEM = new BlockItem(GREEN_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem RED_ARMORED_METAL_ITEM = new BlockItem(RED_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));
	public static BlockItem BLACK_ARMORED_METAL_ITEM = new BlockItem(BLACK_ARMORED_METAL_BLOCK, new FabricItemSettings().group(ITEM_GROUP));



	public static Enchantment PATIENCE_ENCHANTMENT = new PatienceEnchantment();
	public static Enchantment BOBBER_ENCHANTMENT = new BobberEnchantment();
	public static Enchantment TOUGHNESS_ENCHANTMENT = new ToughnessEnchantment();

	public static Item BRONZE_INGOT = new Item(new FabricItemSettings().group(ITEM_GROUP));
	public static Item STEEL_INGOT = new Item(new FabricItemSettings().group(ITEM_GROUP));

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "logo_item"), LOGO_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fur"), FUR);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fur_helmet"), FUR_USHANKA);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fur_chestplate"), FUR_COAT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fur_leggings"), FUR_PANTS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fur_boots"), VALENKI);


		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightweight_helmet"), PANAMA_HAT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightweight_chestplate"), T_SHIRT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightweight_leggings"), LIGHTWEIGHT_SHORTS);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightweight_boots"), SNEAKERS);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "raw_wolf_meat"), WOLF_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cooked_wolf_meat"), COOKED_WOLF_MEAT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brass_sword"), BRASS_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brass_shovel"), BRASS_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brass_pickaxe"), BRASS_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brass_axe"), BRASS_AXE);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brass_hoe"), BRASS_HOE);

		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "landmine"), LANDMINE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "landmine"), LANDMINE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "partially_assembled_landmine"), PARTIALLY_ASSEMBLED_LANDMINE);



		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "white_armored_concrete_block"), WHITE_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "orange_armored_concrete_block"), ORANGE_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "magenta_armored_concrete_block"), MAGENTA_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "light_blue_armored_concrete_block"), LIGHT_BLUE_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "yellow_armored_concrete_block"), YELLOW_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lime_armored_concrete_block"), LIME_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "pink_armored_concrete_block"), PINK_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "gray_armored_concrete_block"), GRAY_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "light_gray_armored_concrete_block"), LIGHT_GRAY_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cyan_armored_concrete_block"), CYAN_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purple_armored_concrete_block"), PURPLE_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "blue_armored_concrete_block"), BLUE_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "brown_armored_concrete_block"), BROWN_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "green_armored_concrete_block"), GREEN_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "red_armored_concrete_block"), RED_ARMORED_CONCRETE_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "black_armored_concrete_block"), BLACK_ARMORED_CONCRETE_BLOCK);


		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "white_armored_metal_block"), WHITE_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "orange_armored_metal_block"), ORANGE_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "magenta_armored_metal_block"), MAGENTA_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "light_blue_armored_metal_block"), LIGHT_BLUE_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "yellow_armored_metal_block"), YELLOW_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "lime_armored_metal_block"), LIME_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "pink_armored_metal_block"), PINK_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "gray_armored_metal_block"), GRAY_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "light_gray_armored_metal_block"), LIGHT_GRAY_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "cyan_armored_metal_block"), CYAN_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "purple_armored_metal_block"), PURPLE_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "blue_armored_metal_block"), BLUE_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "brown_armored_metal_block"), BROWN_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "green_armored_metal_block"), GREEN_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "red_armored_metal_block"), RED_ARMORED_METAL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "black_armored_metal_block"), BLACK_ARMORED_METAL_BLOCK);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "white_armored_concrete_block"), WHITE_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orange_armored_concrete_block"), ORANGE_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "magenta_armored_concrete_block"), MAGENTA_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "light_blue_armored_concrete_block"), LIGHT_BLUE_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "yellow_armored_concrete_block"), YELLOW_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lime_armored_concrete_block"), LIME_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pink_armored_concrete_block"), PINK_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gray_armored_concrete_block"), GRAY_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "light_gray_armored_concrete_block"), LIGHT_GRAY_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cyan_armored_concrete_block"), CYAN_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purple_armored_concrete_block"), PURPLE_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blue_armored_concrete_block"), BLUE_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brown_armored_concrete_block"), BROWN_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "green_armored_concrete_block"), GREEN_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "red_armored_concrete_block"), RED_ARMORED_CONCRETE_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "black_armored_concrete_block"), BLACK_ARMORED_CONCRETE_ITEM);


		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "white_armored_metal_block"), WHITE_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "orange_armored_metal_block"), ORANGE_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "magenta_armored_metal_block"), MAGENTA_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "light_blue_armored_metal_block"), LIGHT_BLUE_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "yellow_armored_metal_block"), YELLOW_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lime_armored_metal_block"), LIME_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "pink_armored_metal_block"), PINK_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "gray_armored_metal_block"), GRAY_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "light_gray_armored_metal_block"), LIGHT_GRAY_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "cyan_armored_metal_block"), CYAN_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "purple_armored_metal_block"), PURPLE_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "blue_armored_metal_block"), BLUE_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brown_armored_metal_block"), BROWN_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "green_armored_metal_block"), GREEN_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "red_armored_metal_block"), RED_ARMORED_METAL_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "black_armored_metal_block"), BLACK_ARMORED_METAL_ITEM);

		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "patience"), PATIENCE_ENCHANTMENT);
		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "float"), BOBBER_ENCHANTMENT);
		Registry.register(Registry.ENCHANTMENT, new Identifier(MOD_ID, "toughness"), TOUGHNESS_ENCHANTMENT);

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "bronze_ingot"), BRONZE_INGOT);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "steel_ingot"), STEEL_INGOT);


	}
}
