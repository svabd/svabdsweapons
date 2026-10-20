package net.sv_abd.svabdsweapons;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.sv_abd.svabdsweapons.entity.ModEntities;
import net.sv_abd.svabdsweapons.entity.render.LuxBoltRenderer;

// This class will not load on dedicated servers. Accessing client side code from here is safe.
@Mod(value = SvabdsWeapons.MOD_ID, dist = Dist.CLIENT)
// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = SvabdsWeapons.MOD_ID, value = Dist.CLIENT)
public class SvabdsWeaponsClient {
    public SvabdsWeaponsClient(ModContainer container) {

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        // This links your LuxBolt entity type to your custom renderer
        event.registerEntityRenderer(ModEntities.LUX_BOLT.get(), LuxBoltRenderer::new);
    }
}
