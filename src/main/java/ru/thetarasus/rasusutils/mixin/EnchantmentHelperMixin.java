package ru.thetarasus.rasusutils.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.thetarasus.rasusutils.horse.HorseHook;

@Mixin({EnchantmentHelper.class})
public abstract class EnchantmentHelperMixin {
   @Inject(
           method = "getEquipmentLevel",
           at = {@At("HEAD")},
           cancellable = true
   )
   private static void checkHorse(Enchantment enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir) {
      HorseHook.checkHorseHook(enchantmentIn, entityIn, cir);
   }

   @Unique
   private static Enchantment currentEnchantment;

   @Redirect(method = "getPossibleEntries", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;isAvailableForRandomSelection()Z"))
   private static boolean isAvailableForRandomSelection(Enchantment enchantment) {

      currentEnchantment = enchantment;
      return enchantment.isAvailableForRandomSelection();
   }

   @Redirect(method = "getPossibleEntries", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentTarget;isAcceptableItem(Lnet/minecraft/item/Item;)Z"))
   private static boolean isAcceptableItem(EnchantmentTarget enchantmentTarget, Item item) {
      ItemStack stack = new ItemStack(item);

      if(item instanceof HorseArmorItem)
         return currentEnchantment.isAcceptableItem(stack);

      return enchantmentTarget.isAcceptableItem(item);
   }
}