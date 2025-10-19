package it.fpetito.moreforniturecobblemon.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class PokeBallStatue extends HorizontalFacingBlock {

    public static final MapCodec<PokeBallStatue> CODEC = PokeBallStatue.createCodec(PokeBallStatue::new);

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(0, 16, 0, 16, 24, 16),         // Base up
            Block.createCuboidShape(0, 0, 0, 16, 3, 16),           // Base down
            Block.createCuboidShape(1, 3, 1, 15, 16, 15),          // central body
            Block.createCuboidShape(4, 24, 4, 12, 28, 12),         // Poké Ball down part
            Block.createCuboidShape(4, 28, 4, 12, 32, 12)          // Poké Ball up part
    ).reduce(VoxelShapes::union).get();

    public PokeBallStatue(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
