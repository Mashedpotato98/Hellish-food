package net.fabricmc.hellish.block;


import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.hellish.block.custom.QuarkCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final CropBlock QUARK_CROP_BLOCK = new QuarkCropBlock(AbstractBlock.Settings.
    of(Material.PLANT).nonOpaque().noCollision().
    ticksRandomly().breakInstantly().
    sounds(BlockSoundGroup.CROP));


	public static final Item QUARK_SEEDS = new AliasedBlockItem(QUARK_CROP_BLOCK,new Item.Settings());


    public static void registerBlocks(){
        //QUARK SEEDS

		Registry.register(Registries.ITEM,new Identifier("hellish","quark_seeds"),QUARK_SEEDS);
		Registry.register(Registries.BLOCK,new Identifier("hellish","quark_crop"),QUARK_CROP_BLOCK);


		//hellish

		//ItemGroupEvents.modifyEntriesEvent(NATURAL).register(entries -> entries.add(QUARK_CROP_BLOCK));
		//ItemGroupEvents.modifyEntriesEvent(NATURAL).register(entries -> entries.add(QUARK_SEEDS));

		
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), QUARK_CROP_BLOCK);
    }
}
