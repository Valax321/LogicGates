package com.valax321.logicgates.common.blocks;

import com.valax321.logicgates.LogicGatesMod;
import net.minecraft.block.BlockRedstoneComparator;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Base class for redstone logic gates
 */
public class BaseRedstoneLogicGate extends BlockRedstoneDiode
{
    public static final PropertyBool POWERED = PropertyBool.create("powered");

    public BaseRedstoneLogicGate(String name, boolean powered)
    {
        super(powered);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.REDSTONE);
        this.setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(POWERED, false));
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING, POWERED);
    }

    public boolean getOutputValue(boolean lhs, boolean rhs) { return false; }

    @Override
    protected int getDelay(IBlockState state) { return 2; } //Same as comparator

    @Override
    protected IBlockState getPoweredState(IBlockState unpoweredState)
    {
        boolean powered = unpoweredState.getValue(POWERED);
        EnumFacing facing = unpoweredState.getValue(FACING);

        return getDefaultState().withProperty(FACING, facing).withProperty(POWERED, powered);
    }

    @Override
    protected IBlockState getUnpoweredState(IBlockState poweredState)
    {
        boolean powered = poweredState.getValue(POWERED);
        EnumFacing facing = poweredState.getValue(FACING);

        return getDefaultState().withProperty(FACING, facing).withProperty(POWERED, powered);
    }

    @Override
    protected boolean isPowered(IBlockState state)
    {
        return this.isRepeaterPowered || state.getValue(POWERED);
    }

    @Override
    protected boolean shouldBePowered(World worldIn, BlockPos pos, IBlockState state)
    {
        int i = this.calculateInputStrength(worldIn, pos, state);

        if (i == 0)
            return false;

        EnumFacing facing = state.getValue(FACING);
        EnumFacing left = getLeftDirection(facing);
        EnumFacing right = getRightDirection(facing);

        int leftPower = this.getPowerOnSide(worldIn, pos, left);
        int rightPower = this.getPowerOnSide(worldIn, pos, right);

        boolean calc = getOutputValue(leftPower > 0, rightPower > 0);

        return calc;
    }

    private EnumFacing getLeftDirection(EnumFacing dir)
    {
        switch (dir)
        {
            case NORTH:
                return EnumFacing.WEST;
            case EAST:
                return EnumFacing.NORTH;
            case SOUTH:
                return EnumFacing.EAST;
            case WEST:
                return EnumFacing.SOUTH;
            default:
                return EnumFacing.WEST;
        }
    }

    private EnumFacing getRightDirection(EnumFacing dir)
    {
        switch (dir)
        {
            case NORTH:
                return EnumFacing.EAST;
            case EAST:
                return EnumFacing.SOUTH;
            case SOUTH:
                return EnumFacing.WEST;
            case WEST:
                return EnumFacing.NORTH;
            default:
                return EnumFacing.EAST;
        }
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()).withProperty(POWERED, false);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
        i = i | (state.getValue(FACING)).getHorizontalIndex();

        if (state.getValue(POWERED))
        {
            i |= 8;
        }

        return i;
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState()
                   .withProperty(FACING, EnumFacing.getHorizontal(meta))
                   .withProperty(POWERED, (meta & 8) > 0);
    }

    public ItemBlock createItemBlock()
    {
        ItemBlock block = new ItemBlock(this);
        block.setRegistryName(getUnlocalizedName());
        return block;
    }
}
