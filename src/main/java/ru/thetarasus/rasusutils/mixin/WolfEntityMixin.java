package ru.thetarasus.rasusutils.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.thetarasus.rasusutils.RasusUtils;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;
import java.util.UUID;

@Mixin(WolfEntity.class)
public class WolfEntityMixin extends TameableEntity implements Angerable {

	protected WolfEntityMixin(EntityType<? extends TameableEntity> entityType, World world) {
		super(entityType, world);
	}

	@Inject(at = @At("HEAD"), method = "onDeath", cancellable = true)
	public void onDeath(DamageSource source, CallbackInfo ci) {
		Random r = new Random();
		if(r.nextBoolean()) {
			this.dropItem(RasusUtils.FUR);
		}
		this.dropItem(RasusUtils.WOLF_MEAT);
	}


	@Override
	public int getAngerTime() {
		return 0;
	}

	@Override
	public void setAngerTime(int angerTime) {

	}

	@Nullable
	@Override
	public UUID getAngryAt() {
		return null;
	}

	@Override
	public void setAngryAt(@Nullable UUID angryAt) {

	}

	@Override
	public void chooseRandomAngerTime() {

	}

	@Nullable
	@Override
	public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
		return null;
	}
}
