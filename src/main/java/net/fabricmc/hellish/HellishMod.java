package net.fabricmc.hellish;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.hellish.block.ModBlocks;
import net.fabricmc.hellish.item.ModItems;

public class HellishMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("hellish");


	@Override
	public void onInitialize() {
		ModItems.RegisterItems();
		ModBlocks.registerBlocks();
	}
}
