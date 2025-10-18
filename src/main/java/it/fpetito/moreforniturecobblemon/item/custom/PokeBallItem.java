package it.fpetito.moreforniturecobblemon.item.custom;

import it.fpetito.moreforniturecobblemon.MoreFornitureCobblemon;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallBlock;
import it.fpetito.moreforniturecobblemon.block.custom.PokeBallVariant;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

public class PokeBallItem extends BlockItem {

    private final PokeBallVariant variant;

    public PokeBallItem(Block block, Settings settings, PokeBallVariant variant) {
        super(block, settings);
        this.variant = variant;
    }

    @Override
    protected @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return getBlock().getDefaultState().with(PokeBallBlock.VARIANT, variant);
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.translatable("item." + MoreFornitureCobblemon.MOD_ID + ".poke_balls/" + variant.asString());
    }
}
