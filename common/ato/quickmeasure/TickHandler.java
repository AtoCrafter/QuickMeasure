package ato.quickmeasure;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

import java.util.EnumSet;

public class TickHandler implements ITickHandler {

    private final GuiMeasure gui;

    public TickHandler(GuiMeasure gui) {
        this.gui = gui;
    }

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        gui.renderGameOverlay();
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER);
    }

    @Override
    public String getLabel() {
        return "QuickMeasureDisplay";
    }
}
