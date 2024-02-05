package eldritch.cookie.kubejs.mysticalagriculture.recipe.component;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import dev.latvian.mods.kubejs.item.InputItem;
import dev.latvian.mods.kubejs.recipe.ItemMatch;
import dev.latvian.mods.kubejs.recipe.RecipeJS;
import dev.latvian.mods.kubejs.recipe.RecipeKey;
import dev.latvian.mods.kubejs.recipe.ReplacementMatch;
import dev.latvian.mods.kubejs.recipe.component.ComponentRole;
import dev.latvian.mods.kubejs.recipe.component.MapRecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.util.TinyMap;

public class InputItemWithCountComponent implements RecipeComponent<InputItem>{
    @Override
		public String componentType() {
			return "input_item";
		}

		@Override
		public ComponentRole role() {
			return ComponentRole.INPUT;
		}

		@Override
		public Class<?> componentClass() {
			return InputItem.class;
		}

		@Override
		public boolean hasPriority(RecipeJS recipe, Object from) {
			return recipe.inputItemHasPriority(from);
		}

		@Override
		public JsonElement write(RecipeJS recipe, InputItem value) {
			JsonElement res = recipe.writeInputItem(value);
      if(res instanceof JsonArray){
        throw new IllegalArgumentException("Item Ingredient Can't be array");
      }
      if(res instanceof JsonObject obj){
        obj.addProperty("count",value.count);
        return obj;
      }
      return res;
		}

		@Override
		public InputItem read(RecipeJS recipe, Object from) {
			return recipe.readInputItem(from);
		}

		@Override
		public boolean isInput(RecipeJS recipe, InputItem value, ReplacementMatch match) {
			return match instanceof ItemMatch m && value.validForMatching() && m.contains(value.ingredient);
		}

		@Override
		public String checkEmpty(RecipeKey<InputItem> key, InputItem value) {
			if (value.isEmpty()) {
				return "Ingredient '" + key.name + "' can't be empty!";
			}

			return "";
		}

		@Override
		public RecipeComponent<TinyMap<Character, InputItem>> asPatternKey() {
			return MapRecipeComponent.ITEM_PATTERN_KEY;
		}

		@Override
		public String toString() {
			return componentType();
		}
}
