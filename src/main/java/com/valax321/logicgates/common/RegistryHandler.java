package com.valax321.logicgates.common;

import com.valax321.logicgates.LogicGatesMod;
import com.valax321.logicgates.common.blocks.LogicGatesBlocks;
import com.valax321.logicgates.common.items.LogicGatesItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = LogicGatesMod.MODID)
public class RegistryHandler
{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        LogicGatesBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        LogicGatesItems.register(event.getRegistry());
        LogicGatesBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event)
    {
        LogicGatesBlocks.registerModels();
        LogicGatesItems.registerModels();
    }

    public static void registerItemModel(ItemBlock itemBlock, int meta, String name)
    {
        LogicGatesMod.proxy.registerItemRenderer(itemBlock, meta, name);
    }
}
