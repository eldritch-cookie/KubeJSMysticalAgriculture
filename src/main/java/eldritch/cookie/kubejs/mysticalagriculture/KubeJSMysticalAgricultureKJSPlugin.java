package eldritch.cookie.kubejs.mysticalagriculture;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropRecipes;
import com.blakebr0.mysticalagriculture.api.crop.CropTextures;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.lib.LazyIngredient;
import com.blakebr0.mysticalagriculture.api.soul.MobSoulType;
import com.blakebr0.mysticalagriculture.api.util.MobSoulUtils;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RecipeComponentFactoryRegistry;
import dev.latvian.mods.kubejs.recipe.schema.RecipeSchemaRegistry;
import dev.latvian.mods.kubejs.script.BindingRegistry;
import dev.latvian.mods.kubejs.script.TypeWrapperRegistry;
// import eldritch.cookie.kubejs.mysticalagriculture.recipe.EnchanterRecipeSchema;
// import eldritch.cookie.kubejs.mysticalagriculture.recipe.InfusionRecipeSchema;
// import eldritch.cookie.kubejs.mysticalagriculture.recipe.ReprocessorRecipeSchema;
// import eldritch.cookie.kubejs.mysticalagriculture.recipe.SoulExtractionRecipeSchema;
// import eldritch.cookie.kubejs.mysticalagriculture.recipe.SouliumSpawnerRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.bindings.event.MysticalAgricultureStartupEvents;
import eldritch.cookie.kubejs.mysticalagriculture.component.Misc;
import net.minecraft.resources.ResourceLocation;

public class KubeJSMysticalAgricultureKJSPlugin implements KubeJSPlugin {
  @Override
  public void registerEvents(EventGroupRegistry registry) {
    registry.register(MysticalAgricultureStartupEvents.GROUP);
  }

  @Override
  public void registerRecipeSchemas(RecipeSchemaRegistry regRS) {

    regRS.namespace(MysticalAgricultureAPI.MOD_ID)
    // .register("enchanter",EnchanterRecipeSchema.SCHEMA)
    // .register("infusion",InfusionRecipeSchema.SCHEMA)
    // .register("reprocessor",ReprocessorRecipeSchema.SCHEMA)
    // .register("soul_extraction",SoulExtractionRecipeSchema.SCHEMA)
    // .register("soulium_spawner",SouliumSpawnerRecipeSchema.SCHEMA)
    ;
  }

  @Override
  public void registerTypeWrappers(TypeWrapperRegistry typeWrappers) {
    typeWrappers.register(
        Crop.class,
        (ctx, o, ti) -> {
          if (o instanceof Crop c) return c;
          if (o instanceof CharSequence cs)
            return MysticalAgricultureAPI.getCropRegistry()
                .getCropById(ResourceLocation.parse(cs.toString()));
          return null;
        });
    typeWrappers.register(
        CropTier.class,
        (ctx, o, ti) -> {
          if (o instanceof CropTier c) return c;
          if (o instanceof CharSequence cs)
            return MysticalAgricultureAPI.getCropRegistry()
                .getTierById(ResourceLocation.parse(cs.toString()));
          return null;
        });
    typeWrappers.register(
        CropType.class,
        (ctx, o, ti) -> {
          if (o instanceof CropType c) return c;
          if (o instanceof CharSequence cs)
            return MysticalAgricultureAPI.getCropRegistry()
                .getTypeById(ResourceLocation.parse(cs.toString()));
          return null;
        });
    typeWrappers.register(
        LazyIngredient.class,
        (ctx, o, ti) -> {
          if (o instanceof LazyIngredient l) return l;
          if (o instanceof CharSequence cs) {
            String s = cs.toString();
            if (s.startsWith("#")) return LazyIngredient.tag(s.substring(1));
            else return LazyIngredient.item(s);
          }
          return null;
        });
    typeWrappers.register(
        MobSoulType.class,
        (ctx, o, ti) -> {
          if (o instanceof MobSoulType mst) return mst;
          if (o instanceof CharSequence cs)
            return MysticalAgricultureAPI.getMobSoulTypeRegistry()
                .getMobSoulTypeById(ResourceLocation.parse(cs.toString()));
          return null;
        });
  }

  @Override
  public void registerBindings(BindingRegistry event) {
    event.add("Crop", Crop.class);
    event.add("CropTier", CropTier.class);
    event.add("CropType", CropType.class);
    event.add("CropRecipes", CropRecipes.class);
    event.add("CropTextures", CropTextures.class);
    event.add("MobSoulUtils", MobSoulUtils.class);
  }

  @Override
  public void registerRecipeComponents(RecipeComponentFactoryRegistry registry) {
    registry.register(Misc.ENCHANTMENT_COMPONENT);
  }
}
