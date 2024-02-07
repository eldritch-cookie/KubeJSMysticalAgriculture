package eldritch.cookie.kubejs.mysticalagriculture.recipe.component;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.soul.MobSoulType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import net.minecraft.resources.ResourceLocation;

public class MobSoulTypeComponent implements RecipeComponent<MobSouls>{
  @Override
  public Class<?> componentClass() {
    return MobSouls.class;
  }

  @Override
  public String componentType() {
    return "mob_souls";
  }

  @Override
  public JsonElement write(RecipeJS recipe, MobSouls value) {
    final JsonObject ret = new JsonObject ();
    ret.addProperty("type",value.type().getId().toString());
    ret.addProperty("count",value.count());
    return ret;
  }

  @Override
  public MobSouls read(RecipeJS recipe, Object from) {
    // TODO Auto-generated method stub
    if(from instanceof MobSouls soul){
      return soul;
    }
    if(from instanceof JsonObject obj){
      return new MobSouls(
          MysticalAgricultureAPI
            .getMobSoulTypeRegistry()
            .getMobSoulTypeById(
              new ResourceLocation(
                obj.get("type").getAsString()
              )
            ),
            obj.get("count").getAsDouble()
        );
    }
    throw new UnsupportedOperationException("Unimplemented method 'read'");
  }

}
