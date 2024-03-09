package ru.thetarasus.rasusutils.mixin;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = {"net.minecraft.enchantment.EnchantmentTarget$1","net.minecraft.enchantment.EnchantmentTarget$2", "net.minecraft.enchantment.EnchantmentTarget$3", "net.minecraft.enchantment.EnchantmentTarget$4", "net.minecraft.enchantment.EnchantmentTarget$5"})
public abstract class EnchantmentTypeMixin {
   @Inject(method = "isAcceptableItem", at = @At("RETURN"), cancellable = true)
   private void enchantHorseArmor(Item itemIn, CallbackInfoReturnable<Boolean> cir) {
      if (!(Boolean)cir.getReturnValue()) {
         if (itemIn instanceof HorseArmorItem) {
            cir.setReturnValue(true);
         }

      }
   }
}