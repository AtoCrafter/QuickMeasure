package ato.quickmeasure.measure;

import ato.quickmeasure.EntityMeasure;
import ato.quickmeasure.KeyHandler;
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
        int num = KeyHandler.getDownNumber();
        if (num == 0) {
            num = 10;
        }
        if (world != null && num > 0) {
            entity = new EntityMeasure(world, num);
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
