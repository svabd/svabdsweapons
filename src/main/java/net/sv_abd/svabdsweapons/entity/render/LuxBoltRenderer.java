package net.sv_abd.svabdsweapons.entity.render;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sv_abd.svabdsweapons.SvabdsWeapons;
import net.sv_abd.svabdsweapons.entity.custom.LuxBolt;
import org.jetbrains.annotations.NotNull;

public class LuxBoltRenderer extends EntityRenderer<LuxBolt> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(SvabdsWeapons.MOD_ID, "textures/entity/projectiles/custom_projectile.png");

    public LuxBoltRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull LuxBolt entity) {
        return TEXTURE;
    }
}
