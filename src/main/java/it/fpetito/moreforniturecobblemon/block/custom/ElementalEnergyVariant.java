package it.fpetito.moreforniturecobblemon.block.custom;

import net.minecraft.util.StringIdentifiable;

public enum ElementalEnergyVariant  implements StringIdentifiable {
    FIRE,
    WATER,
    //GRASS,
    ELECTRIC,
    //PSYCHIC,
    //FIGHTING,
    //DARK,
    //METAL,
    //FAIRY,
    //DRAGON,
    //COLORLESS
    ;

    @Override
    public String asString() {
        return name().toLowerCase();
    }
}
