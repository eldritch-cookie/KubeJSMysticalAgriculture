package eldritch.cookie.kubejs.mysticalagriculture;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.AwakeningRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.EnchanterRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.InfusionRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.ReprocessorRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.SoulExtractionRecipeSchema;
import eldritch.cookie.kubejs.mysticalagriculture.recipe.SouliumSpawnerRecipeSchema;

//import static eldritch.cookie.kubejs.mysticalagriculture.KubeJSMysticalAgriculture.*;
public class KubeJSMysticalAgricultureKJSPlugin extends KubeJSPlugin {
  @Override
  public void registerEvents() {
    // CropRegistry
    // MobSoulRegistry
    // AugmentRegistry
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
}
