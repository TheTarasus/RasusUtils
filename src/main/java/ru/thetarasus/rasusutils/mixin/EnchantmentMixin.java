package ru.thetarasus.rasusutils.mixin;

import net.minecraft.enchantment.AquaAffinityEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.thetarasus.rasusutils.RasusUtils;

import java.util.stream.Stream;

import static net.minecraft.enchantment.Enchantments.*;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

    @Shadow @Final public EnchantmentTarget type;

    @Inject(at = @At("HEAD"), method = "isAcceptableItem", cancellable = true)
    public void isAcceptableItem(ItemStack item, CallbackInfoReturnable<Boolean> cir){
        if(!(item.getItem() instanceof HorseArmorItem)) return;

        boolean isHorseAccepted = Stream.of(AQUA_AFFINITY,
                FROST_WALKER,
                BINDING_CURSE,
                DEPTH_STRIDER,
                SOUL_SPEED,
                THORNS,
                VANISHING_CURSE,
                RasusUtils.BOBBER_ENCHANTMENT,
                RasusUtils.PATIENCE_ENCHANTMENT,
                RasusUtils.TOUGHNESS_ENCHANTMENT).anyMatch(enchantment -> (Enchantment) (Object) this == enchantment);

        cir.setReturnValue(isHorseAccepted);
    }

}
