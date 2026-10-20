package net.sv_abd.svabdsweapons.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sv_abd.svabdsweapons.SvabdsWeapons;
import net.sv_abd.svabdsweapons.entity.custom.LuxBolt;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(Registries.ENTITY_TYPE, SvabdsWeapons.MOD_ID);

    public static final DeferredHolder<EntityType<?>, EntityType<LuxBolt>> LUX_BOLT =
            ENTITIES.register("lux_bolt", () -> EntityType.Builder.<LuxBolt>of(LuxBolt::new, MobCategory.MISC)
                    .sized(0.25F, 0.25F) // Collision box dimensions
                    .build("lux_bolt"));


    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
