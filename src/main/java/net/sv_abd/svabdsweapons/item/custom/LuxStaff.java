package net.sv_abd.svabdsweapons.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.sv_abd.svabdsweapons.entity.custom.LuxBolt;
import org.jetbrains.annotations.NotNull;

public class LuxStaff extends Item {
    public LuxStaff(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

        if (!level.isClientSide) {
            LuxBolt projectile = new LuxBolt(level, player);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(projectile);

            // OPTIONAL: Reduce item durability if you want it to wear down over time
            // itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        }

        player.awardStat(Stats.ITEM_USED.get(this));

        // 1. REMOVED: The itemstack.shrink(1) block has been completely removed

        // 2. ADDED: Add a short cooldown (e.g., 20 ticks = 1 second) so it cannot be spammed
        player.getCooldowns().addCooldown(this, 20);

        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
