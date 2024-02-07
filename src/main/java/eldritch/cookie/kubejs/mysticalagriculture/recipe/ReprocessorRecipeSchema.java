package eldritch.cookie.kubejs.mysticalagriculture.recipe;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.item.OutputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.ItemComponents;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;

public interface ReprocessorRecipeSchema {
  RecipeKey<InputItem> INPUT = ItemComponents.INPUT.key("input");
  RecipeKey<OutputItem> RESULT = ItemComponents.OUTPUT.key("result");
  RecipeSchema SCHEMA = new RecipeSchema(RESULT,INPUT)
    .uniqueOutputId(RESULT);
}
