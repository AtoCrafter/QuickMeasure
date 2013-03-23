package ato.quickmeasure;

import ato.quickmeasure.measure.MeasurePoint;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.TickType;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import java.util.EnumSet;

public class KeyHandler extends KeyBindingRegistry.KeyHandler {

    private static final KeyBinding key = new KeyBinding("QuickMeasure Switch Key", Keyboard.KEY_C);
    private final MeasuresManager manager;

    public KeyHandler(MeasuresManager manager) {
        super(new KeyBinding[]{key}, new boolean[]{false});
        this.manager = manager;
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
        if (kb == key && !tickEnd) {
            if (manager.getActiveMeasure() == null) {
                manager.setActiveMeasure(new MeasurePoint());
            } else {
                manager.setActiveMeasure(null);
            }
        }
    }

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
    }

    @Override
    public EnumSet<TickType> ticks() {
        return EnumSet.of(TickType.RENDER);
    }

    @Override
    public String getLabel() {
        return "QuickMeasureSwitchKey";
    }
}
