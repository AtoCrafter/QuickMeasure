package ato.quickmeasure.measure;

import ato.quickmeasure.EntityMeasure;
import ato.quickmeasure.KeyHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

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
        World world = Minecraft.getMinecraft().theWorld;
        MovingObjectPosition omo = Minecraft.getMinecraft().objectMouseOver;
        int num = KeyHandler.getDownNumber();
        if (num == 0) {
            num = 10;
        }
        if (world != null && num > 0 && omo.typeOfHit == EnumMovingObjectType.TILE) {
            entity = new EntityMeasure(world, omo.blockX, omo.blockY, omo.blockZ, num);
            world.spawnEntityInWorld(entity);
            super.start();
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
