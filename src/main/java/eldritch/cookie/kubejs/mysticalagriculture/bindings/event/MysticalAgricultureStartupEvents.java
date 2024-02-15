package eldritch.cookie.kubejs.mysticalagriculture.bindings.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import eldritch.cookie.kubejs.mysticalagriculture.registry.CropRegistryEventJS;
import eldritch.cookie.kubejs.mysticalagriculture.registry.MobSoulTypeRegistryEventJS;

public interface MysticalAgricultureStartupEvents {
  EventGroup GROUP = EventGroup.of("MysticalAgricultureStartupEvents");
  //EventHandler AUGMENT = GROUP.startup("augment",() -> );
  EventHandler MOB_SOUL = GROUP.startup("mob_soul",() -> MobSoulTypeRegistryEventJS.class);
  EventHandler CROP = GROUP.startup("crop",() -> CropRegistryEventJS.class);
}
