package eldritch.cookie.kubejs.mysticalagriculture.recipe;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ComponentValueMap;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.component.NumberComponent;
import dev.latvian.mods.kubejs.recipe.component.StringComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.MobSoulTypeComponent;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.MobSouls;
import net.minecraft.resources.ResourceLocation;

public interface SoulExtractionRecipeSchema {
  public class SoulExtractionRecipeJS extends RecipeJS
  {
    private RecipeJS valueMapAccept(ComponentValueMap from){
      setValue(INPUT,from.getValue(this,INPUT));
      setValue(OUTPUT,new MobSouls(MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeById(ResourceLocation.parse(from.getValue(this,TYPE))),from.getValue(this,SOULS)));
      return this;
    }
  }
  RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("input");
  RecipeKey<MobSouls> OUTPUT = new MobSoulTypeComponent()
    .key("output");
  RecipeKey<String> TYPE = StringComponent.ID.key("type");
  RecipeKey<Double> SOULS = NumberComponent.DOUBLE.key("souls");
  RecipeSchema SCHEMA = new RecipeSchema(SoulExtractionRecipeJS.class,SoulExtractionRecipeJS::new,OUTPUT,INPUT)
    .constructor(OUTPUT,INPUT)
    .constructor((recipe,schemaType,keys,from) -> ((SoulExtractionRecipeJS)recipe).valueMapAccept(from),TYPE,SOULS,INPUT);
}
