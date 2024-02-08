package eldritch.cookie.kubejs.mysticalagriculture.recipe;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.InputItemWithCountComponent;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.WeightedEntityComponent;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.WeightedEntity;

public interface SouliumSpawnerRecipeSchema {
  RecipeKey<InputItem> INPUT = new InputItemWithCountComponent()
    .key("input");
  RecipeKey<WeightedEntity[]> ENTITIES = new WeightedEntityComponent()
    .asArray()
    .key("entities");
  RecipeSchema SCHEMA = new RecipeSchema(ENTITIES,INPUT).uniqueInputId(INPUT);
}
