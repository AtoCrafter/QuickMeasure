package ato.quickmeasure;

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
            manager.toggleRunning();
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

    /**
     * 現在押している数字キーを返す
     */
    public static int getDownNumber() {
        if (Keyboard.isKeyDown(Keyboard.KEY_1)) {
            return 1;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_2)) {
            return 2;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_3)) {
            return 3;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_4)) {
            return 4;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_5)) {
            return 5;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_6)) {
            return 6;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_7)) {
            return 7;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_8)) {
            return 8;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_9)) {
            return 9;
        } else if (Keyboard.isKeyDown(Keyboard.KEY_0)) {
            return 0;
        } else {
            return -1;
        }
    }
}
