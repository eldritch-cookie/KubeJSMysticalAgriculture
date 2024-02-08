package eldritch.cookie.kubejs.mysticalagriculture.recipe.component;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import dev.latvian.mods.kubejs.util.MapJS;
import net.minecraft.resources.ResourceLocation;

public class WeightedEntityComponent implements RecipeComponent<WeightedEntity>{

  @Override
  public String componentType() {
    return "weighted_entity";
  }

  @Override
  public Class<?> componentClass() {
    return WeightedEntity.class;
  }

  @Override
  public JsonElement write(RecipeJS recipe, WeightedEntity value) {
    JsonObject ret = new JsonObject();
    ret.addProperty("entity",RegistryInfo.ENTITY_TYPE.getId(value.entity()).toString());
    ret.addProperty("weight",value.weight());
    return ret;
  }


  @Override
  public WeightedEntity read(RecipeJS recipe, Object from) {
    if(from instanceof WeightedEntity we) {
      return we;
    }
    JsonObject obj = MapJS.json(from);
    return new WeightedEntity(RegistryInfo.ENTITY_TYPE.getValue(new ResourceLocation(obj.get("entity").getAsString())), obj.has("weight") ? obj.get("weight").getAsInt() : 1);
  }
   
}
