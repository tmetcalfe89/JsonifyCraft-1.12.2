package com.timinc.jsonifycraft.description;

import com.timinc.jsonifycraft.JsonifyCraft;
import com.timinc.jsonifycraft.description.providers.IProviderItem;
import com.timinc.jsonifycraft.world.JsonedItem;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDescription extends JsonDescription implements IProviderItem {
    public String name;

    @Override
    public List<Item> getItems() {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new JsonedItem(this).setRegistryName(name)
                .setUnlocalizedName(JsonifyCraft.MODID + "." + name));

        return items;
    }
}
