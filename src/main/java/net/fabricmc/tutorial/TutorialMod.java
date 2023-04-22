package net.fabricmc.tutorial;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.tutorial.block.custom.QuarkCropBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("tutorial");

	//Quark seeds

	public static final CropBlock QUARK_CROP_BLOCK = new QuarkCropBlock(AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));
	public static final Item QUARK_SEEDS = new AliasedBlockItem(TutorialMod.QUARK_CROP_BLOCK,new Item.Settings());
	public static final Item QUARK_PIECES = new Item(new FabricItemSettings());

	//Hellish food
	public static final Item HELLISH_APPLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*35)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*7),100)
			.build()));
	public static final Item HELLISH_CARROT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(14.4F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*35),100).build()));
	public static final Item HELLISH_STEAK = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(8).saturationModifier(13.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*35),100).build()));

	//Enderio Trees

	public static final Item ENDERIO_WARTS = new Item(new FabricItemSettings());

	public static final Item ENDERIO_STEAK = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*15),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*15),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,20*15),100).build()));
	public static final Item ENDERIO_APPLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*10),100)
			.build()));
	public static final Item ENDERIO_CARROT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*15),100)
			.build()));


	@Override
	public void onInitialize() {
		//QUARK SEEDS

		Registry.register(Registries.ITEM,new Identifier("tutorial","quark_seeds"),QUARK_SEEDS);
		Registry.register(Registries.BLOCK,new Identifier("tutorial","quark_crop"),QUARK_CROP_BLOCK);
		Registry.register(Registries.ITEM,new Identifier("tutorial","quark_pieces"),QUARK_PIECES);

		Registry.register(Registries.ITEM,new Identifier("tutorial","hellish_apple"),HELLISH_APPLE);
		Registry.register(Registries.ITEM,new Identifier("tutorial","hellish_carrot"),HELLISH_CARROT);
		Registry.register(Registries.ITEM,new Identifier("tutorial","hellish_steak"),HELLISH_STEAK);


		//Enderio trees
		Registry.register(Registries.ITEM,new Identifier("tutorial","enderio_warts"),ENDERIO_WARTS);

		Registry.register(Registries.ITEM,new Identifier("tutorial","enderio_carrot"),ENDERIO_CARROT);
		Registry.register(Registries.ITEM,new Identifier("tutorial","enderio_apple"),ENDERIO_APPLE);
		Registry.register(Registries.ITEM,new Identifier("tutorial","enderio_steak"),ENDERIO_STEAK);





		//hellish

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(QUARK_CROP_BLOCK));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(QUARK_SEEDS));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(QUARK_PIECES));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(HELLISH_APPLE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(HELLISH_CARROT));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(HELLISH_STEAK));

		//Enderio trees
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_WARTS));

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_APPLE));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_CARROT));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_STEAK));



		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), QUARK_CROP_BLOCK);

		LOGGER.info("Hello Fabric world!");
	}
}
