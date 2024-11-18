package eldritch.cookie.kubejs.mysticalagriculture.registry;

import java.util.ArrayList;
import java.util.List;

import com.blakebr0.mysticalagriculture.api.crop.Crop;
import com.blakebr0.mysticalagriculture.api.crop.CropTier;
import com.blakebr0.mysticalagriculture.api.crop.CropType;
import com.blakebr0.mysticalagriculture.api.registry.ICropRegistry;

import dev.latvian.mods.kubejs.event.KubeStartupEvent;
import dev.latvian.mods.kubejs.registry.RegistryCallback;
import net.minecraft.resources.ResourceLocation;

public class CropRegistryEvent implements KubeStartupEvent {
  // TODO: make Registry Event implementation use custom filters similarly to recipes
  // TODO: implement removeCrop(CropFilter)
  // TODO: implement removeCropTier(CropTierFilter)
  // TODO: implement removeCropType(CropTypeFilter)
  // TODO: implement modifyCrop(CropFilter,Consumer<Crop>)
  // TODO: implement modifyCropTier(CropTierFilter,Consumer<CropTier>)
  // TODO: implement modifyCropType(CropTypeFilter,Consumer<CropType>)
  public final ICropRegistry registry;
  public final List<CropBuilder> createdCrops = new ArrayList<CropBuilder>();
  public final List<CropTierBuilder> createdTiers = new ArrayList<CropTierBuilder>();
  public final List<CropTypeBuilder> createdCropTypes = new ArrayList<CropTypeBuilder>();

  public CropRegistryEvent(ICropRegistry registry){
    this.registry = registry;
  }

}
