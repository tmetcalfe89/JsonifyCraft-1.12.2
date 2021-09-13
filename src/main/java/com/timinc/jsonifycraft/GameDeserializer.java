package com.timinc.jsonifycraft;

import com.google.gson.*;
import com.timinc.jsonifycraft.description.JsonDescription;

import java.lang.reflect.Type;
import java.util.HashMap;

public class GameDeserializer implements JsonDeserializer<JsonDescription> {
    private static HashMap<String, Type> gameObjectClasses = new HashMap<>();

    public static void registerDescription(String name, Type type) {
        JsonifyCraft.log("Registering game object deserializer: %s", name);
        gameObjectClasses.put(name, type);
    }

    @Override
    public JsonDescription deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonifyCraft.log("Deserializing game object: %s", type);
        return context.deserialize(jsonObject, gameObjectClasses.get(type));
    }
}