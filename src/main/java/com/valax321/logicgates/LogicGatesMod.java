package com.valax321.logicgates;

import com.valax321.logicgates.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = LogicGatesMod.MODID, name = LogicGatesMod.NAME, version = LogicGatesMod.VERION)
public class LogicGatesMod
{
    public static final String MODID = "logicgates";
    public static final String NAME = "LogicGates";
    public static final String VERION = "1.0";

    private static Logger logger;
    public static Logger getLogger() { return logger; }

    @SidedProxy(clientSide = "com.valax321.logicgates.client.ClientProxy", serverSide = "com.valax321.logicgates.server.ServerProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt)
    {
        logger = evt.getModLog();
        proxy.preInit(evt);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent evt)
    {
        proxy.init(evt);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent evt)
    {
        proxy.postInit(evt);
    }
}
