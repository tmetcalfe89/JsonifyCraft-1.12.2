package com.timinc.jsonifycraft.world;

import com.timinc.jsonifycraft.description.BlockDescription;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class JsonedBlockItem extends ItemBlock {
    private BlockDescription description;

    public JsonedBlockItem(Block block, BlockDescription blockDescription) {
        super(block);
        this.description = blockDescription;
    }
}
