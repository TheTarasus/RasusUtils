package ru.thetarasus.rasusutils.horse;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;

public class ToughnessEnchantment extends Enchantment {

    public ToughnessEnchantment() {
        super(Rarity.COMMON, EnchantmentTarget.ARMOR, new EquipmentSlot[]{});
    }


    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof HorseArmorItem;
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof ProtectionEnchantment) && this != other;
    }

    @Override
    public int getProtectionAmount(int level, DamageSource source) {
        return level * 5;
    }

    @Override
    public int getMinPower(int level) {
        return 5 + ((level - 1) * 11);
    }
    @Override
    public int getMaxPower(int level){
        return getMinPower(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
