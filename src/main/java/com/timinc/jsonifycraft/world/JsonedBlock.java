package com.timinc.jsonifycraft.world;

import com.timinc.jsonifycraft.description.BlockDescription;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class JsonedBlock extends Block {
    private final BlockDescription description;

    public JsonedBlock(BlockDescription blockDescription) {
        super(Material.GROUND, MapColor.ADOBE);
        this.description = blockDescription;
    }
}
