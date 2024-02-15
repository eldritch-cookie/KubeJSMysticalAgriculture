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

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import dev.latvian.mods.kubejs.script.BindingsEvent;
import dev.latvian.mods.kubejs.script.ScriptType;
import dev.latvian.mods.rhino.util.wrap.TypeWrappers;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.AwakeningRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.EnchanterRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.InfusionRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.ReprocessorRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.SoulExtractionRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.SouliumSpawnerRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.bindings.event.MysticalAgricultureStartupEvents;
import net.minecraft.resources.ResourceLocation;

//import static eldritch.cookie.kubejs.mysticalagriculture.KubeJSMysticalAgriculture.*;
public class KubeJSMysticalAgricultureKJSPlugin extends KubeJSPlugin {
  @Override
  public void registerEvents() {
    MysticalAgricultureStartupEvents.GROUP.register();
  }
  @Override
  public void registerRecipeSchemas(RegisterRecipeSchemasEvent event){
    
    event.namespace(MysticalAgricultureAPI.MOD_ID)
      .register("awakening",AwakeningRecipeSchema.SCHEMA)
      .register("enchanter",EnchanterRecipeSchema.SCHEMA)
      .register("infusion",InfusionRecipeSchema.SCHEMA)
      .register("reprocessor",ReprocessorRecipeSchema.SCHEMA)
      .register("soul_extraction",SoulExtractionRecipeSchema.SCHEMA)
      .register("soulium_spawner",SouliumSpawnerRecipeSchema.SCHEMA)
      ;
  }
  @Override
  public void registerTypeWrappers(ScriptType type, TypeWrappers typeWrappers){
    typeWrappers.register(Crop.class,(ctx,o) -> {
      if (o instanceof Crop c) return c;
      if (o instanceof CharSequence cs) return MysticalAgricultureAPI.getCropRegistry().getCropById(new ResourceLocation(cs.toString()));
      return null;
    });
    typeWrappers.register(CropTier.class,(ctx,o) -> {
      if (o instanceof CropTier c) return c;
      if (o instanceof CharSequence cs) return MysticalAgricultureAPI.getCropRegistry().getTierById(new ResourceLocation(cs.toString()));
      return null;
    });
    typeWrappers.register(CropType.class,(ctx,o) -> {
      if (o instanceof CropType c) return c;
      if (o instanceof CharSequence cs) return MysticalAgricultureAPI.getCropRegistry().getTypeById(new ResourceLocation(cs.toString()));
      return null;
    });
    typeWrappers.register(LazyIngredient.class, (ctx,o) -> {
      if(o instanceof LazyIngredient l) return l;
      if(o instanceof CharSequence cs) {
        String s = cs.toString();
        if(s.startsWith("#")) return LazyIngredient.tag(s.substring(1));
        else return LazyIngredient.item(s);
      }
      return null;
    });
    typeWrappers.register(MobSoulType.class, (ctx,o)-> {
      if(o instanceof MobSoulType mst) return mst;
      if(o instanceof CharSequence cs) return MysticalAgricultureAPI.getMobSoulTypeRegistry().getMobSoulTypeById(new ResourceLocation(cs.toString()));
      return null;
    });
  }
  @Override
  public void registerBindings(BindingsEvent event) {
    event.add("Crop",Crop.class);
    event.add("CropTier",CropTier.class);
    event.add("CropType",CropType.class);
    event.add("CropRecipes",CropRecipes.class);
    event.add("CropTextures",CropTextures.class);
    event.add("MobSoulUtils",MobSoulUtils.class);
  }
}
