package com.valax321.logicgates.common.blocks;

public class RedstoneXnorGate extends BaseRedstoneLogicGate
{
    public RedstoneXnorGate(boolean powered)
    {
        super("xnor_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs)
    {
        return lhs == rhs;
    }
}
