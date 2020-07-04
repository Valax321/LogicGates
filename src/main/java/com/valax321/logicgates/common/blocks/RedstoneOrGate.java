package com.valax321.logicgates.common.blocks;

public class RedstoneOrGate extends BaseRedstoneLogicGate
{
    public RedstoneOrGate(boolean powered)
    {
        super("or_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs) { return lhs || rhs; }
}
