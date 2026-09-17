package com.mallowwww.landfallorigins.registry;

import com.mallowwww.landfallorigins.LandfallOrigins;
import com.mallowwww.landfallorigins.api.OriginType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.NewRegistryEvent;
import net.neoforged.neoforge.registries.RegistryBuilder;
@EventBusSubscriber
public class OriginRegistry {
    public static final Registry<OriginType> ORIGIN_TYPES = new RegistryBuilder<OriginType>(
            ResourceKey.createRegistryKey(LandfallOrigins.path("origin_types"))
    ).create();

    @SubscribeEvent
    public static void init(NewRegistryEvent event) {
        event.register(ORIGIN_TYPES);
    }
}
