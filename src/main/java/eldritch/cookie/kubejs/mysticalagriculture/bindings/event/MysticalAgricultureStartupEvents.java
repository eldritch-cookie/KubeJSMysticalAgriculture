package eldritch.cookie.kubejs.mysticalagriculture.bindings.event;

import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventHandler;
import eldritch.cookie.kubejs.mysticalagriculture.registry.CropRegistryEvent;
import eldritch.cookie.kubejs.mysticalagriculture.registry.MobSoulTypeRegistryEvent;

public interface MysticalAgricultureStartupEvents {
  EventGroup GROUP = EventGroup.of("MysticalAgricultureStartupEvents");
  // TODO: add event for augments
  EventHandler MOB_SOUL = GROUP.startup("mob_soul", () -> MobSoulTypeRegistryEvent.class);
  EventHandler CROP = GROUP.startup("crop", () -> CropRegistryEvent.class);
}
