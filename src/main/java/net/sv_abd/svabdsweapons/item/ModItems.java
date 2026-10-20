package net.sv_abd.svabdsweapons.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sv_abd.svabdsweapons.SvabdsWeapons;
import net.sv_abd.svabdsweapons.item.custom.LuxStaff;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(SvabdsWeapons.MOD_ID);

    public static DeferredItem<LuxStaff> LUX_STAFF = ITEMS.register("lux_staff",
            () -> new LuxStaff(new Item.Properties().stacksTo(1)));

    public static void register(IEventBus iEventBus) {
        ITEMS.register(iEventBus);
    }
}
