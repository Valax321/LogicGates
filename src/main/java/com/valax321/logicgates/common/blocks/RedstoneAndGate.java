package com.valax321.logicgates.common.blocks;

import net.minecraft.block.state.IBlockState;

public class RedstoneAndGate extends BaseRedstoneLogicGate
{
    public RedstoneAndGate(boolean powered)
    {
        super("and_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs)
    {
        return lhs && rhs;
    }
}
