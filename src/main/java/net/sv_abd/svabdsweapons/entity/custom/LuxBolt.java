package net.sv_abd.svabdsweapons.entity.custom;

import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.sv_abd.svabdsweapons.entity.ModEntities;
import org.jetbrains.annotations.NotNull;

public class LuxBolt extends Projectile {

    public LuxBolt(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    public LuxBolt(Level level, LivingEntity shooter) {
        this(ModEntities.LUX_BOLT.get(), level);
        this.setOwner(shooter);
        // Position the projectile at the shooter's eyes
        this.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
    }

    @Override
    protected void onHitEntity(@NotNull EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide && result.getEntity() instanceof LivingEntity target) {
            // Apply damage or custom effects here
            target.hurt(this.damageSources().thrown(this, this.getOwner()), 4.0F);
            if (target instanceof Player) {

            }
        }
    }

    @Override
    protected void onHit(@NotNull HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            // Discard the entity once it hits a block or entity
            this.discard();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {

    }
}
