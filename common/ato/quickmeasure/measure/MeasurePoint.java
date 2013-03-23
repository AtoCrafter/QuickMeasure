package ato.quickmeasure.measure;

import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;

/**
 * 座標の計測
 */
public class MeasurePoint extends Measure {

    /**
     * 計測開始点
     */
    private int ox, oy, oz;

    @Override
    public String getText() {
        MovingObjectPosition mo = Minecraft.getMinecraft().objectMouseOver;
        if (running && mo != null && mo.entityHit == null) {
            int dx = mo.blockX - ox;
            int dy = mo.blockY - oy;
            int dz = mo.blockZ - oz;
            return "(" + dx + "," + dy + "," + dz + ")"
                    + String.format(" %.2f", Vec3.createVectorHelper(dx, dy, dz).distanceTo(Vec3.createVectorHelper(0, 0, 0)));
        } else {
            return null;
        }
    }

    @Override
    public void start() {
        MovingObjectPosition mo = Minecraft.getMinecraft().objectMouseOver;
        if (mo != null && mo.entityHit == null) {
            super.start();
            ox = mo.blockX;
            oy = mo.blockY;
            oz = mo.blockZ;
        }
    }
}
