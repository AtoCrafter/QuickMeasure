package ato.quickmeasure;

import ato.quickmeasure.measure.Measure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

/**
 * ゲーム画面上に計測結果を表示するための GUI クラス
 */
public class GuiMeasure extends Gui {

    private final MeasuresManager manager;
    private final Minecraft mc;

    public GuiMeasure(MeasuresManager manager, Minecraft mc) {
        this.manager = manager;
        this.mc = mc;
    }

    /**
     * 画面に計測結果を表示
     *
     * @see net.minecraft.client.gui.GuiIngame#renderGameOverlay(float, boolean, int, int)
     */
    public void renderGameOverlay() {
        // Gui を開いていたり、タイトル画面だったりした場合は表示しない
        if (mc.currentScreen != null) {
            return;
        }

        Measure measure = manager.getActiveMeasure();
        if (measure != null) {
            String text = measure.getText();
            if (text != null) {
                ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
                int centerX = scaledresolution.getScaledWidth() / 2;
                int centerY = scaledresolution.getScaledHeight() / 2 + 10;
                drawCenteredString(mc.fontRenderer, text, centerX, centerY, 0xFFFFFF);
            }
        }
    }
}
