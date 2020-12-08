package com.otakusaikou.plantcraft.block;

import com.otakusaikou.plantcraft.item.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class CropStickBlock extends Block {
    public static final BooleanProperty IS_JOINED = BooleanProperty.create("joined");

    public CropStickBlock(Properties properties) {
        super(properties);
        //When the Crop Stick placed, it should not be joined.
        this.setDefaultState(getDefaultState().with(IS_JOINED, false));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(IS_JOINED);
        super.fillStateContainer(builder);
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        // We don't need to detect world.isRemote here.
        if (handIn == Hand.MAIN_HAND) {
            ItemStack mainHandStack = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND);
            if (!state.get(IS_JOINED) && mainHandStack.getItem() == ItemRegistry.cropStickItem.get()) {
                worldIn.setBlockState(pos, state.with(IS_JOINED, true));
                mainHandStack.shrink(1);
            } else if (state.get(IS_JOINED)) {
                worldIn.setBlockState(pos, state.with(IS_JOINED, false));
                //To get better Item spawn effect, we add 1 to Y.
                worldIn.addEntity(new ItemEntity(worldIn, pos.getX(), pos.getY() + 1, pos.getZ(), new ItemStack(ItemRegistry.cropStickItem.get(), 1)));
            }
        }
        return ActionResultType.SUCCESS;
    }
}
