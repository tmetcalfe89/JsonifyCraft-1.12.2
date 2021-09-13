package com.timinc.jsonifycraft;

import com.timinc.jsonifycraft.description.BlockDescription;
import com.timinc.jsonifycraft.description.ItemDescription;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = JsonifyCraft.MODID, name = JsonifyCraft.NAME, version = JsonifyCraft.VERSION)
public class JsonifyCraft
{
    public static final String MODID = "jsonifycraft";
    public static final String NAME = "JsonifyCraft";
    public static final String VERSION = "2.0.0";

    private static final Logger LOGGER = LogManager.getLogger(NAME);

    private static DescriptionLoader GAME_OBJECTS;

    public JsonifyCraft() {
        setup();
    }

    public void setup() {
        registerDeserializers();
        loadGameObjects();
    }

    public void registerDeserializers() {
        GameDeserializer.registerDescription("item", ItemDescription.class);
        GameDeserializer.registerDescription("block", BlockDescription.class);
    }

    public void loadGameObjects() {
        GAME_OBJECTS = new DescriptionLoader();
    }

    public static void log(String message, Object... variables) {
        LOGGER.info(String.format(message, variables));
    }

    @Mod.EventBusSubscriber
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            GAME_OBJECTS.registerItems(itemRegistryEvent.getRegistry());
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            GAME_OBJECTS.registerBlocks(blockRegistryEvent.getRegistry());
        }
    }
}
