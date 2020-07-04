package com.valax321.logicgates.common.blocks;

public class RedstoneXorGate extends BaseRedstoneLogicGate
{
    public RedstoneXorGate(boolean powered)
    {
        super("xor_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs)
    {
        return lhs != rhs;
    }
}
