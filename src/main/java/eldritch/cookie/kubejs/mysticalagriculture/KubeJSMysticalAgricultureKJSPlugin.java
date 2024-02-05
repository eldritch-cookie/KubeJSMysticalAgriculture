package eldritch.cookie.kubejs.mysticalagriculture;
import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;

import dev.latvian.mods.kubejs.KubeJSPlugin;
import dev.latvian.mods.kubejs.recipe.schema.RegisterRecipeSchemasEvent;
public class KubeJSMysticalAgricultureKJSPlugin extends KubeJSPlugin {
  @Override
  public void registerEvents() {
    // CropRegistry
    // MobSoulRegistry
    // AugmentRegistry
  }
  @Override
  public void registerRecipeSchemas(RegisterRecipeSchemasEvent event){
    event.namespace(MysticalAgricultureAPI.MOD_ID);
  }
}
