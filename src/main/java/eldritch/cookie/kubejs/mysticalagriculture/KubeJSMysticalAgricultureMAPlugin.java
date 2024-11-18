package eldritch.cookie.kubejs.mysticalagriculture;

import com.blakebr0.mysticalagriculture.api.IMysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.MysticalAgriculturePlugin;
import com.blakebr0.mysticalagriculture.api.lib.PluginConfig;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;
import com.blakebr0.mysticalagriculture.api.registry.IMobSoulTypeRegistry;

import eldritch.cookie.kubejs.mysticalagriculture.bindings.event.MysticalAgricultureStartupEvents;
import eldritch.cookie.kubejs.mysticalagriculture.registry.CropRegistryEvent;
import eldritch.cookie.kubejs.mysticalagriculture.registry.MobSoulTypeRegistryEvent;

@MysticalAgriculturePlugin
public class KubeJSMysticalAgricultureMAPlugin implements IMysticalAgriculturePlugin{

  @Override
  public void configure(PluginConfig config) {
    config.setModId(KubeJSMysticalAgriculture.MOD_ID);
  }

  @Override
  public void onRegisterCrops(ICropRegistry registry) {
    MysticalAgricultureStartupEvents.CROP.post(new CropRegistryEvent(registry));
  }

  @Override
  public void onRegisterMobSoulTypes(IMobSoulTypeRegistry registry) {
    MysticalAgricultureStartupEvents.MOB_SOUL.post(new MobSoulTypeRegistryEvent(registry));
  }};
