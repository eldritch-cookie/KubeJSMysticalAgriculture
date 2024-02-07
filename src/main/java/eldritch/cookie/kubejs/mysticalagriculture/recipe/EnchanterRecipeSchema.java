package eldritch.cookie.kubejs.mysticalagriculture.recipe;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.component.RegistryComponent;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchema;
import dev.latvian.mods.kubejs.registry.RegistryInfo;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.component.InputItemWithCountComponent;
import net.minecraft.world.item.enchantment.Enchantment;

public interface EnchanterRecipeSchema {
  RecipeKey<InputItem[]> INGREDIENTS = (new InputItemWithCountComponent()).asArray().key("ingredients");
  RecipeKey<Enchantment> ENCHANTMENT = new RegistryComponent<Enchantment>(RegistryInfo.ENCHANTMENT).key("enchantment");
  RecipeSchema SCHEMA = new RecipeSchema(ENCHANTMENT,INGREDIENTS)
    .uniqueId((recipe) -> recipe.getValue(ENCHANTMENT).getDescriptionId());
}
