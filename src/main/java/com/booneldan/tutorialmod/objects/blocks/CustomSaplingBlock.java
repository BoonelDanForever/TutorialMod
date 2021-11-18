package com.booneldan.tutorialmod.objects.blocks;

import com.booneldan.tutorialmod.world.gen.TreeSpawner;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CustomSaplingBlock extends SaplingBlock {

    private final TreeSpawner spawner;

    public CustomSaplingBlock(Properties properties, TreeSpawner spawner) {
        super(null, properties);
        this.spawner = spawner;
    }

    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random random) {
        if(state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            spawner.spawn(world, world.getChunkSource().getGenerator(), pos, state, random);
        }
    }
}
