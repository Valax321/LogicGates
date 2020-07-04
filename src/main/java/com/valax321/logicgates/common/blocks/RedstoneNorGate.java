package com.valax321.logicgates.common.blocks;

public class RedstoneNorGate extends BaseRedstoneLogicGate
{
    public RedstoneNorGate(boolean powered)
    {
        super("nor_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs)
    {
        return !(lhs || rhs);
    }
}
