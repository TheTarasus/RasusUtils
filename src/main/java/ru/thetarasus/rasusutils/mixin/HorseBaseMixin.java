package ru.thetarasus.rasusutils.mixin;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.JumpingMount;
import net.minecraft.entity.Saddleable;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.HorseBaseEntity;
import net.minecraft.inventory.InventoryChangedListener;
import net.minecraft.item.ArmorItem;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import ru.thetarasus.rasusutils.RasusUtils;

@Mixin(HorseBaseEntity.class)
public abstract class HorseBaseMixin extends AnimalEntity implements InventoryChangedListener, JumpingMount, Saddleable {


    protected HorseBaseMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At("HEAD"), method = "setAngry", cancellable = true)
    public void setAngry(boolean angry, CallbackInfo cir){
        boolean toReturn = EnchantmentHelper.getEquipmentLevel(RasusUtils.PATIENCE_ENCHANTMENT, (HorseBaseEntity)(Object)this) == 0;
        if(toReturn) return;
        cir.cancel();
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo cir){
        if(!this.touchingWater) return;
        boolean noEnch = EnchantmentHelper.getEquipmentLevel(RasusUtils.BOBBER_ENCHANTMENT, (HorseBaseEntity)(Object) this) == 0;
        if(noEnch) return;
        this.addVelocity(0, 0.1, 0);

    }
}
