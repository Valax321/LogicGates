package com.valax321.logicgates.common.items;

import com.valax321.logicgates.LogicGatesMod;
import com.valax321.logicgates.common.blocks.BaseRedstoneLogicGate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseLogicGateItem extends Item
{
    public BaseLogicGateItem(String name)
    {
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CreativeTabs.REDSTONE);
    }

    public BaseRedstoneLogicGate getPlacedBlock()
    {
        return null;
    }
}
