package it.fpetito.moreforniturecobblemon.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.VariantHolder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;


public class GraveBlock extends HorizontalFacingBlock implements VariantHolder<GraveVariant> {
    public static final MapCodec<GraveBlock> CODEC = GraveBlock.createCodec(GraveBlock::new);

    // EnumProperty per le varianti
    public static final EnumProperty<GraveVariant> VARIANT = EnumProperty.of("variant", GraveVariant.class);

    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 16.0D, 12.0D, 16.0D);

    public GraveBlock(Settings settings) {
        super(settings);
        // Stato di default con facing NORTH e variante DEFAULT
        setDefaultState(getStateManager().getDefaultState()
                .with(VARIANT, GraveVariant.DEFAULT));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, VARIANT);
    }

    // Imposta lo stato del blocco in base all'item che lo piazza
    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        GraveVariant variant = GraveVariant.DEFAULT;

        if (ctx.getStack().getItem() instanceof BlockItem blockItem) {
            String id = blockItem.getRegistryEntry().registryKey().getValue().getPath(); // es. "grave_default"
            for (GraveVariant v : GraveVariant.values()) {
                if (id.endsWith(v.asString())) {
                    variant = v;
                    break;
                }
            }
        }

        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(VARIANT, variant);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void setVariant(GraveVariant variant) {
        // Non serve qui, la variante è gestita dallo stato del blocco
    }

    @Override
    public GraveVariant getVariant() {
        // Restituisce la variante basata sullo stato del blocco, NON una variabile statica
        return getDefaultState().get(VARIANT);
    }

}
