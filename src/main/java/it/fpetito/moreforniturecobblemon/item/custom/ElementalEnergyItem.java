package it.fpetito.moreforniturecobblemon.item.custom;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.custom.ElementalEnergyBlock;
import it.fpetito.moreforniturecobblemon.block.custom.ElementalEnergyVariant;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class ElementalEnergyItem extends BlockItem {
    private final ElementalEnergyVariant variant;

    public ElementalEnergyItem(Block block, Settings settings, ElementalEnergyVariant variant) {
        super(block, settings);
        this.variant = variant;
    }

    @Override
    protected @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return getBlock().getDefaultState().with(ElementalEnergyBlock.VARIANT, variant)
                .with(PokeBallBlock.FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item." + MoreFornitureCobblemon.MOD_ID + ".elemental_energy/" + variant.asString());
    }
}
