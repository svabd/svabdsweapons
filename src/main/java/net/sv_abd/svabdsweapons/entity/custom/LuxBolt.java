package net.sv_abd.svabdsweapons.entity.custom;

import foundry.veil.VeilClient;
import foundry.veil.api.client.render.post.PostPipeline;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.sv_abd.svabdsweapons.SvabdsWeapons;
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
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        // Required method to define any network-synced variables (even if empty)
    }

    @Override
    public void tick() {
        super.tick();

        // 1. Handle collision detection manually
        HitResult hitResult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitResult.getType() != HitResult.Type.MISS) {
            this.hitTargetOrDeflectSelf(hitResult);
        }

        // 2. Perform manual movement physics
        Vec3 movement = this.getDeltaMovement();
        double nextX = this.getX() + movement.x;
        double nextY = this.getY() + movement.y;
        double nextZ = this.getZ() + movement.z;

        this.setDeltaMovement(movement.x, movement.y, movement.z);

        this.setPos(nextX, nextY, nextZ);
    }

    @Override
    protected void onHitBlock(@NotNull BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level().isClientSide()) {
            this.discard();
        }
    }

    // Required serialization for saving/loading data from NBT tags
    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        // 1. Get the entity that was hit
        Entity hitEntity = result.getEntity();

        // 2. Perform actions on the server side (e.g., damaging the entity)
        if (!this.level().isClientSide()) {
            if (hitEntity instanceof LivingEntity livingTarget) {
                // Deal damage to the living entity
                livingTarget.hurt(this.damageSources().thrown(this, this.getOwner()), 5.0F);

                if (livingTarget instanceof Player player) {

                }
            }
        }
    }
}
