package eldritch.cookie.kubejs.mysticalagriculture.registry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.blakebr0.mysticalagriculture.api.MysticalAgricultureAPI;
import com.blakebr0.mysticalagriculture.api.crop.CropType;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class CropTypeBuilder implements Supplier<CropType> {
  public record CraftingSeedGenerationInfo(ResourceLocation item, ResourceLocation texture){}
  protected CropType cropType;
  public final ResourceLocation id;
  public final List<CraftingSeedGenerationInfo> toGenerate = new ArrayList<CraftingSeedGenerationInfo>();
  private ResourceLocation stemModel;
  private Supplier<? extends Item> craftingSeed;
  
  public CropTypeBuilder(ResourceLocation id){
    this.id = id;
  }
  @Override
  public CropType get() {
    return cropType;
  }
  public CropType createCropType(){
    cropType = stemModel == null ? new CropType(id,ResourceLocation.fromNamespaceAndPath(MysticalAgricultureAPI.MOD_ID, "block/mystical_resource_crop")) : new CropType(id,stemModel);
    if(craftingSeed != null) {
      cropType.setCraftingSeed(craftingSeed);
    }
    return cropType;
  }
  public CropTypeBuilder setCraftingSeed(Supplier<? extends Item> craftingSeed){
    this.craftingSeed = craftingSeed;
    return this;
  }
  public CropTypeBuilder setCraftingSeed(Item craftingSeed){
    this.craftingSeed = () -> craftingSeed;
    return this;
  }
  public CropTypeBuilder setCraftingSeedToGenerated(){
    return this;
  }
  public CropTypeBuilder setStemModel(String stemModel){
    this.stemModel = ResourceLocation.parse(stemModel);
    return this;
  }


}

