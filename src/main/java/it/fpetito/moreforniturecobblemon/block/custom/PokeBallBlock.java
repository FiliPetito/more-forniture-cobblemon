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
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PokeBallBlock extends HorizontalFacingBlock implements VariantHolder<PokeBallVariant> {
    public static final MapCodec<GraveBlock> CODEC = GraveBlock.createCodec(GraveBlock::new);

    public static final EnumProperty<PokeBallVariant> VARIANT = EnumProperty.of("variant", PokeBallVariant.class);
    private static PokeBallVariant BLOCK_VARIANT = PokeBallVariant.POKE_BALL;

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(4, 0, 4, 12, 4, 12),           // down part
            Block.createCuboidShape(4, 4, 4, 12, 8, 12)
    ).reduce(VoxelShapes::union).get();

    public PokeBallBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(VARIANT, PokeBallVariant.POKE_BALL));
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
        PokeBallVariant variant = PokeBallVariant.POKE_BALL;

        if(stack.getItem() instanceof BlockItem blockItem){
            String id = Registries.ITEM.getId(blockItem).getPath(); // es. "grave_small"
            for (PokeBallVariant v : PokeBallVariant.values()) {
                if (id.equalsIgnoreCase(v.asString())) {
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
    public void setVariant(PokeBallVariant variant) {
        BLOCK_VARIANT = variant;
    }

    @Override
    public PokeBallVariant getVariant() {
        return BLOCK_VARIANT;
    }

}
