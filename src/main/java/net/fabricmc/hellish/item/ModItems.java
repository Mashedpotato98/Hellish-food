package net.fabricmc.hellish.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
   public static final Item QUARK_PIECES = new Item(new FabricItemSettings());

    public static final Item ENDERIO_WARTS = new Item(new FabricItemSettings());


	//hellish food
	public static final Item hellish_APPLE = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*35)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*7),100)
			.build()));


	public static final Item hellish_CARROT = new Item(new FabricItemSettings().food(new FoodComponent.Builder().hunger(7).saturationModifier(14.4F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*35),100).build()));


	public static final Item hellish_STEAK = new Item(new FabricItemSettings().food
    (new FoodComponent.Builder().hunger(8).saturationModifier(13.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*35),100).build()));



        //end

            public static final Item ENDERIO_STEAK = new Item(new FabricItemSettings().food
            (new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*15),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,20*15),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,20*15),100).build()));


	public static final Item ENDERIO_APPLE = new Item(new FabricItemSettings().food
    (new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*10),100)
			.build()));


	public static final Item ENDERIO_CARROT = new Item(new FabricItemSettings().food
    (new FoodComponent.Builder().hunger(5).saturationModifier(9.0F).alwaysEdible()
			.statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,20*40)
					,100).statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,20*60),100)
			.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,20*15),100)
			.build()));


        public static void RegisterItems(){
            //hellish
            Registry.register(Registries.ITEM,new Identifier("hellish","quark_pieces"),QUARK_PIECES);

            Registry.register(Registries.ITEM,new Identifier("hellish","hellish_apple"),hellish_APPLE);
            Registry.register(Registries.ITEM,new Identifier("hellish","hellish_carrot"),hellish_CARROT);
            Registry.register(Registries.ITEM,new Identifier("hellish","hellish_steak"),hellish_STEAK);
    
    
            //end
            Registry.register(Registries.ITEM,new Identifier("hellish","enderio_warts"),ENDERIO_WARTS);
    
            Registry.register(Registries.ITEM,new Identifier("hellish","enderio_carrot"),ENDERIO_CARROT);
            Registry.register(Registries.ITEM,new Identifier("hellish","enderio_apple"),ENDERIO_APPLE);
            Registry.register(Registries.ITEM,new Identifier("hellish","enderio_steak"),ENDERIO_STEAK);



            //hellish
            //ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(QUARK_PIECES));

            //ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(hellish_APPLE));
            //ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(hellish_CARROT));
           // ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(hellish_STEAK));
    


            //End
           // ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_WARTS));
    
            //ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_APPLE));
           // ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_CARROT));
           // ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(ENDERIO_STEAK));
    
        }
}
