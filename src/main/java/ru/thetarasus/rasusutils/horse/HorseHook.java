package ru.thetarasus.rasusutils.horse;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class HorseHook {

    public static void checkHorseHook(Enchantment enchantmentIn, LivingEntity entityIn, CallbackInfoReturnable<Integer> cir) {
        if (entityIn instanceof HorseEntity) {
            ItemStack armor = ((HorseEntity)entityIn).getArmorType();
            if (armor.getItem() instanceof HorseArmorItem) {
                int level = EnchantmentHelper.getLevel(enchantmentIn, armor);
                cir.setReturnValue(level);
            }
        }

    }

}
