package eldritch.cookie.kubejs.mysticalagriculture.registry;

import com.blakebr0.mysticalagriculture.api.registry.IMobSoulTypeRegistry;

import dev.latvian.mods.kubejs.event.KubeStartupEvent;

public class MobSoulTypeRegistryEvent implements KubeStartupEvent{
  // TODO: make Registry Event implementation use custom filters similarly to recipes
  // TODO: implement remove(MobSoulTypeFilter)
  // TODO: implement modify(MobSoulTypeFilter, Consumer<MobSoulType>)
  public final IMobSoulTypeRegistry registry;
  public MobSoulTypeRegistryEvent(IMobSoulTypeRegistry registry){
    this.registry = registry;
  }
}
