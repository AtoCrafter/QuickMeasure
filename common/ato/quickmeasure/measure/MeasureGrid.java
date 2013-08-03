package ato.quickmeasure.measure;

import ato.quickmeasure.EntityMeasure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

/**
 * 周期的なブロック数の計測
 */
public class MeasureGrid extends Measure {

    /**
     * レンダリングするためのエンティティ
     */
    private EntityMeasure entity;

    @Override
    public String getText() {
        return null;
    }

    @Override
    public void start() {
        super.start();
        World world = Minecraft.getMinecraft().theWorld;
        if (world != null) {
            entity = new EntityMeasure(world);
            world.spawnEntityInWorld(entity);
        }
    }

    @Override
    public void stop() {
        if (entity != null) {
            entity.destroy();
        }
        super.stop();
    }
}
