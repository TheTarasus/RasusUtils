package ru.thetarasus.rasusutils.horse;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;

public class BobberEnchantment extends Enchantment {
    public BobberEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{});
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof FrostWalkerEnchantment) && super.canAccept(other);
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
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof HorseArmorItem;
    }
}
