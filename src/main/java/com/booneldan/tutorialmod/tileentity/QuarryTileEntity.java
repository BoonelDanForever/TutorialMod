package com.booneldan.tutorialmod.tileentity;

import com.booneldan.tutorialmod.init.ModTileEntityTypes;
import com.booneldan.tutorialmod.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;


public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick;
    boolean initialized = false;

    public QuarryTileEntity(final TileEntityType<?> tileEntityType) {
        super(tileEntityType);
    }

    public QuarryTileEntity() {
        this(ModTileEntityTypes.QUARRY.get());
    }

    @Override
    public void tick() {
        if(!initialized) {
            init();
            tick++;
            if(tick == 40) {
                tick = 0;
                if(y > 2) {
                    execute();
                }
            }
        }
    }

    private void execute() {
        int index = 0;
        Block[] blocksRemoved = new Block[9];
        for(int x = 0; x < 3; x++) {
            for(int z = 0; z < 3; z++) {
                BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
                blocksRemoved[index] = this.level.getBlockState(posToBreak).getBlock();
                destroyBlock(posToBreak, true, null);
                index++;
            }
        }
        this.y--;
    }

    private void init() {
        this.initialized = true;
        x = this.getBlockPos().getX() - 1;
        y = this.getBlockPos().getY() - 1;
        z = this.getBlockPos().getZ() - 1;
        this.tick = 0;
    }

    private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
        BlockState blockState = level.getBlockState(pos);
        if(blockState.isAir(level, pos)){
            return false;
        } else {
            FluidState fluidState = level.getFluidState(pos);
            level.levelEvent(2001, pos, Block.getId(blockState));
            if(dropBlock) {
                TileEntity tileEntity = blockState.hasTileEntity() ? level.getBlockEntity(pos) : null;
                Block.dropResources(blockState, level, this.getBlockPos().offset(0, 1.5, 0), tileEntity, entity, ItemStack.EMPTY);
            }
            return level.setBlock(pos, fluidState.createLegacyBlock(), 3);
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.save(compound);
    }

    @Override
    public void load(BlockState blockState, CompoundNBT compound) {
        super.load(blockState, compound);
        CompoundNBT initValues = compound.getCompound("initvalues");
        if(initValues != null) {
            this.x = initValues.getInt("x");
            this.y = initValues.getInt("y");
            this.z = initValues.getInt("z");
            this.tick = 0;
            initialized = true;
            return;
        } else {
            init();
        }
    }
}
