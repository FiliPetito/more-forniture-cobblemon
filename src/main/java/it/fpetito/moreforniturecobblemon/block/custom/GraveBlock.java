package it.fpetito.moreforniturecobblemon.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.VariantHolder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;


public class GraveBlock extends HorizontalFacingBlock implements VariantHolder<GraveVariant> {

    public static final MapCodec<GraveBlock> CODEC = GraveBlock.createCodec(GraveBlock::new);

    public static final EnumProperty<GraveVariant> VARIANT = EnumProperty.of("variant", GraveVariant.class);
    private static GraveVariant BLOCK_VARIANT = GraveVariant.DEFAULT;

    private static final VoxelShape SHAPE = Block.createCuboidShape(3.0D, 0.0D, 3.0D, 16.0D, 12.0D, 16.0D);

    public GraveBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(VARIANT, GraveVariant.DEFAULT));
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, VARIANT);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        ItemStack stack = ctx.getStack();
        GraveVariant variant = GraveVariant.DEFAULT;

        if(stack.getItem() instanceof BlockItem blockItem){
            String id = Registries.ITEM.getId(blockItem).getPath(); // es. "grave_small"
            for (GraveVariant v : GraveVariant.values()) {
                if (id.endsWith(v.asString())) {
                    variant = v;
                    break;
                }
            }
        }

        BLOCK_VARIANT = variant;

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

    }

    @Override
    public GraveVariant getVariant() {
        return BLOCK_VARIANT;
    }

}
