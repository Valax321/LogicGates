package com.valax321.logicgates.client;

import com.valax321.logicgates.LogicGatesMod;
import com.valax321.logicgates.common.CommonProxy;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy
{
    @Override
    public void registerItemRenderer(Item item, int meta, String id)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(LogicGatesMod.MODID + ":" + id, "inventory"));
    }
}
