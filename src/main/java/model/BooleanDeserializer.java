package model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class BooleanDeserializer implements JsonDeserializer<Boolean> {

    @Override
    public Boolean deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        if (((JsonPrimitive) json).isBoolean()) {
            return json.getAsBoolean();
        }
        if (((JsonPrimitive) json).isString()) {
            String jsonValue = json.getAsString();
            if (jsonValue.equalsIgnoreCase("budjet")) {
                return true;
            } else if (jsonValue.equalsIgnoreCase("contract")) {
                return false;
            }
        }
        return null;
    }
}
