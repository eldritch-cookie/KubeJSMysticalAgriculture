package eldritch.cookie.kubejs.mysticalagriculture.recipe;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;


public interface InfusionRecipeSchema {
  RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("input");
  RecipeKey<InputItem[]> INGREDIENTS = ItemComponents.UNWRAPPED_INPUT_ARRAY.key("ingredients");
  RecipeKey<OutputItem> RESULT = ItemComponents.OUTPUT.key("result");
  RecipeSchema SCHEMA = new RecipeSchema(RESULT,INPUT,INGREDIENTS)
    .uniqueOutputId(RESULT);
}
