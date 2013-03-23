package ato.quickmeasure;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(
        modid = "QuickMeasure",
        name = "Quick Measure",
        version = "@VERSION@"
)
@NetworkMod(
        clientSideRequired = true,
        serverSideRequired = false
)
public class QuickMeasure {

    @SidedProxy(
            serverSide = "ato.quickmeasure.CommonProxy",
            clientSide = "ato.quickmeasure.ClientProxy"
    )
    public static CommonProxy proxy;

    @Init
    public void load(FMLInitializationEvent event) {
        proxy.init();
    }
}
