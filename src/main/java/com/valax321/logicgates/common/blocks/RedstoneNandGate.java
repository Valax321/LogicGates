package com.valax321.logicgates.common.blocks;

public class RedstoneNandGate extends BaseRedstoneLogicGate
{
    public RedstoneNandGate(boolean powered)
    {
        super("nand_gate", powered);
    }

    @Override
    public boolean getOutputValue(boolean lhs, boolean rhs)
    {
        return !(lhs && rhs);
    }
}
