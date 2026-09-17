package com.mallowwww.landfallorigins.api;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

public abstract class OriginType {

    public enum Ability {
        ABILITY_ONE,
        ABILITY_TWO,
        ABILITY_THREE,
        ABILITY_FOUR,
        ABILITY_BONUS
    }

    private final ResourceLocation location;

    public OriginType(ResourceLocation location) {
        this.location = location;
    }

    public final ResourceLocation location() {
        return location;
    }
    public abstract boolean canUseAbility(Ability ability, Player player);
    public abstract void useAbility(Ability ability, Player player);
    public abstract void tick(Player player);
}
