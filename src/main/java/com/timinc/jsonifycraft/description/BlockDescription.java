package com.timinc.jsonifycraft.description;

import com.timinc.jsonifycraft.JsonifyCraft;
import com.timinc.jsonifycraft.description.providers.IProviderBlock;
import com.timinc.jsonifycraft.world.JsonedBlock;
import com.timinc.jsonifycraft.world.JsonedBlockItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class BlockDescription extends ItemDescription implements IProviderBlock {
    private transient List<Block> blocks;

    @Override
    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        getBlocks()
                .forEach(block -> items.add(new JsonedBlockItem(block, this).setRegistryName(block.getRegistryName())
                        .setUnlocalizedName(block.getUnlocalizedName())));
        return items;
    }

    @Override
    public List<Block> getBlocks() {
        if (blocks == null) {
            blocks = new ArrayList<>();

            blocks.add(new JsonedBlock(this).setRegistryName(name)
                    .setUnlocalizedName(JsonifyCraft.MODID + "." + name));
        }
        return blocks;
    }
}
