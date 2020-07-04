package com.valax321.logicgates.common.blocks;

import com.valax321.logicgates.LogicGatesMod;
import com.valax321.logicgates.common.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class LogicGatesBlocks
{
    public static RedstoneAndGate AND_GATE;
    public static RedstoneOrGate OR_GATE;
    public static RedstoneNandGate NAND_GATE;
    public static RedstoneNorGate NOR_GATE;
    public static RedstoneXorGate XOR_GATE;
    public static RedstoneXnorGate XNOR_GATE;

    static
    {
        AND_GATE = new RedstoneAndGate(false);
        AND_GATE = new RedstoneAndGate(false);
        OR_GATE = new RedstoneOrGate(false);
        NAND_GATE = new RedstoneNandGate(false);
        NOR_GATE = new RedstoneNorGate(false);
        XOR_GATE = new RedstoneXorGate(false);
        XNOR_GATE = new RedstoneXnorGate(false);
    }

    public static void register(IForgeRegistry<Block> registry)
    {
        try
        {
            registry.registerAll(
                    AND_GATE,
                    OR_GATE,
                    NAND_GATE,
                    NOR_GATE,
                    XOR_GATE,
                    XNOR_GATE
            );
        }
        catch (Exception ex)
        {
            LogicGatesMod.getLogger().error("ERROR IN BLOCK REGISTRY: %s", ex.getMessage());
            throw ex;
        }
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry)
    {
        try
        {
            registry.registerAll(
                    AND_GATE.createItemBlock(),
                    OR_GATE.createItemBlock(),
                    NAND_GATE.createItemBlock(),
                    NOR_GATE.createItemBlock(),
                    XOR_GATE.createItemBlock(),
                    XNOR_GATE.createItemBlock()
            );
        }
        catch (Exception ex)
        {
            LogicGatesMod.getLogger().error("ERROR IN ITEM BLOCK REGISTRY: %s", ex.getMessage());
            throw ex;
        }
    }

    public static void registerModels()
    {
        try
        {
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(AND_GATE), 0, AND_GATE.getUnlocalizedName());
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(OR_GATE), 0, OR_GATE.getUnlocalizedName());
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(NAND_GATE), 0, NAND_GATE.getUnlocalizedName());
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(NOR_GATE), 0, NOR_GATE.getUnlocalizedName());
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(XOR_GATE), 0, XOR_GATE.getUnlocalizedName());
            RegistryHandler.registerItemModel((ItemBlock)Item.getItemFromBlock(XNOR_GATE), 0, XNOR_GATE.getUnlocalizedName());
        }
        catch (Exception ex)
        {
            LogicGatesMod.getLogger().error("ERROR IN MODEL REGISTRY: %s", ex.getMessage());
            throw ex;
        }
    }
}
