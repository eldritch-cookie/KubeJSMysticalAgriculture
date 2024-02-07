package eldritch.cookie.kubejs.mysticalagriculture.recipe;
import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.InputItemWithCountComponent;

public interface AwakeningRecipeSchema {
  RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("input");
  RecipeKey<InputItem[]> ESSENCES = (new InputItemWithCountComponent()).asArray().key("essences");
  RecipeKey<InputItem[]> INGREDIENTS = ItemComponents.INPUT_ARRAY.key("ingredients");
  RecipeKey<OutputItem> RESULT = ItemComponents.OUTPUT.key("result");
  
  // TODO: check if subclassing is necessary
  RecipeSchema SCHEMA =  new RecipeSchema(RESULT,INPUT,ESSENCES,INGREDIENTS)
    .uniqueOutputId(RESULT);

}
