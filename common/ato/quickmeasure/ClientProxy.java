package ato.quickmeasure;

import ato.quickmeasure.measure.MeasureGrid;
import ato.quickmeasure.measure.MeasurePoint;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;

public class ClientProxy extends CommonProxy {

    @Override
    public void init() {
        super.init();
        MeasuresManager manager = new MeasuresManager();
        manager.setActiveMeasure(new MeasureGrid());
        GuiMeasure gui = new GuiMeasure(manager, Minecraft.getMinecraft());
        KeyBindingRegistry.registerKeyBinding(new KeyHandler(manager));
        TickRegistry.registerTickHandler(new TickHandler(gui), Side.CLIENT);
        RenderingRegistry.registerEntityRenderingHandler(EntityMeasure.class, new RenderGrid());
    }
}
