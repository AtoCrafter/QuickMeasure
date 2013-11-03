package ato.quickmeasure;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import org.lwjgl.opengl.GL11;

public class RenderGrid extends RenderPlayer {

    @Override
    public void doRender(Entity e, double par2X, double par3Y, double par4Z, float f, float f1) {
        EntityMeasure em = (EntityMeasure) e;
        int radius = 10;
        int x = (int) ((em.posX - radius) / em.span) * em.span;
        int y = (int) ((em.posY - radius) / em.span) * em.span;
        int z = (int) ((em.posZ - radius) / em.span) * em.span;
        renderGridLines(x, y, z, em.span, radius * 2 / em.span);
    }

    @Override
    public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
    }

    /**
     * Renders the entity's shadow and fire (if its on fire). Args: entity, x, y, z, yaw, partialTickTime
     */
    @Override
    public void doRenderShadowAndFire(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
    }

    /**
     * グリッド線をレンダリングする
     */
    protected void renderGridLines(double x, double y, double z, int span, int times) {

        // 描画座標をワールド座標系に変換
        double sx = x - renderManager.viewerPosX;
        double sy = y - renderManager.viewerPosY;
        double sz = z - renderManager.viewerPosZ;

        // 描画環境の設定
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        RenderHelper.disableStandardItemLighting();

        Tessellator ins = Tessellator.instance;
        int r = 255;
        int g = 0;
        int b = 0;
        int a = 127;

        ins.startDrawing(GL11.GL_LINES);
        ins.setColorRGBA(r, g, b, a);

        // West-East
        for (int i = 0; i <= times; ++i) {
            for (int j = 0; j <= times; ++j) {
                ins.addVertex(sx, sy + i * span, sz + j * span);
                ins.addVertex(sx + times * span, sy + i * span, sz + j * span);
            }
        }
        // North-South
        for (int i = 0; i <= times; ++i) {
            for (int j = 0; j <= times; ++j) {
                ins.addVertex(sx + i * span, sy + j * span, sz);
                ins.addVertex(sx + i * span, sy + j * span, sz + times * span);
            }
        }
        // Up-Down
        for (int i = 0; i <= times; ++i) {
            for (int j = 0; j <= times; ++j) {
                ins.addVertex(sx + i * span, sy, sz + j * span);
                ins.addVertex(sx + i * span, sy + times * span, sz + j * span);
            }
        }

        ins.draw();

        // 元の描画環境へ戻す
        GL11.glPopMatrix();
        RenderHelper.enableStandardItemLighting();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
    }
}
