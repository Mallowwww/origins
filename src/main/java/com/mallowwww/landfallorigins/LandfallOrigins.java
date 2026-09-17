package com.mallowwww.landfallorigins;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(LandfallOrigins.MODID)
public class LandfallOrigins {
    public static final String MODID = "landfallorigins";
    public static final Logger LOGGER = LogUtils.getLogger();
    public LandfallOrigins(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    public static ResourceLocation path(String s) {
        return ResourceLocation.fromNamespaceAndPath(MODID, s);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
