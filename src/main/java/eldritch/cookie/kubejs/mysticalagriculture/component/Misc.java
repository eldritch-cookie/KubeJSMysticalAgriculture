package eldritch.cookie.kubejs.mysticalagriculture.component;

import dev.latvian.mods.kubejs.recipe.component.RecipeComponent;
import dev.latvian.mods.kubejs.recipe.component.SimpleRecipeComponent;
import dev.latvian.mods.rhino.type.TypeInfo;
import net.minecraft.core.Holder;
import net.minecraft.world.item.enchantment.Enchantment;

public interface Misc {
  RecipeComponent<Holder<Enchantment>> ENCHANTMENT_COMPONENT =
      new SimpleRecipeComponent<>(
          "mysticalagriculture:enchantment", Enchantment.CODEC, TypeInfo.of(Enchantment.class));
}
