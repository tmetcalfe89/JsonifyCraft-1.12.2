package com.timinc.jsonifycraft.world;

import com.timinc.jsonifycraft.description.ItemDescription;
import net.minecraft.item.Item;

public class JsonedItem extends Item {
    private final ItemDescription description;

    public JsonedItem(ItemDescription itemDescription) {
        super();
        this.description = itemDescription;
    }
}
