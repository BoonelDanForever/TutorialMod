package com.booneldan.tutorialmod.util;

import com.booneldan.tutorialmod.init.NewBlockInit;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;

public class StrippingMap {
    public static void createStripable(Block input, Block output) {
        AxeItem.STRIPABLES = Maps.newHashMap(AxeItem.STRIPABLES);
        AxeItem.STRIPABLES.put(input, output);
    }

    public static void registerStripables() {
        createStripable(NewBlockInit.EXAMPLE_LOG.get(), NewBlockInit.EXAMPLE_STRIPPED_LOG.get());
    }
}
