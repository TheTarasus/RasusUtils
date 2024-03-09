package ru.thetarasus.rasusutils.mixin;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
@Mixin({Item.class})
public abstract class ItemMixin implements ItemConvertible, FabricItem {
   @Shadow public abstract Item asItem();

   @Inject(
      at = {@At("HEAD")},
      method = {"getEnchantability"},
      cancellable = true
   )
   private void init(CallbackInfoReturnable<Integer> cir) {
      if ((this.asItem() instanceof HorseArmorItem)) {
         cir.setReturnValue(15);
      }

   }

   @Inject(
      at = {@At("HEAD")},
      method = {"isEnchantable"},
      cancellable = true
   )
   private void init(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
      if (this.asItem() instanceof HorseArmorItem) {
         cir.setReturnValue(true);
      }

   }
}