package it.fpetito.moreforniturecobblemon.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum GraveVariant implements StringIdentifiable {
    DEFAULT,
    GRAY,
    MOSSY,
    COBBLESTONE,
    STONE;

    @Override
    public String asString() { return name().toLowerCase(); }
}
