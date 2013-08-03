package ato.quickmeasure;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class RenderGrid extends RenderPlayer {

    @Override
    public void doRender(Entity e, double x, double y, double z, float f, float f1) {
        renderGridLines(x, y, z);
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
    protected void renderGridLines(double x, double y, double z) {

        // 描画範囲を決定
        double sx = 0;
        double dx = 3;
        double sy = 0;
        double dy = 3;
        double sz = 0;
        double dz = 3;

        // 描画環境の設定
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x, (float) y, (float) z);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
        RenderHelper.disableStandardItemLighting();
        GL11.glDepthMask(false);
        GL11.glDisable(GL11.GL_DEPTH_TEST);

        Tessellator ins = Tessellator.instance;
        int r = 255;
        int g = 0;
        int b = 0;
        int a = 127;

        // Down
        ins.startDrawing(GL11.GL_LINE_LOOP);
        ins.setColorRGBA(r, g, b, a);
        ins.addVertex(sx, sy, sz);
        ins.addVertex(dx, sy, sz);
        ins.addVertex(dx, sy, dz);
        ins.addVertex(sx, sy, dz);
        ins.draw();

        // Up
        ins.startDrawing(GL11.GL_LINE_LOOP);
        ins.setColorRGBA(r, g, b, a);
        ins.addVertex(sx, dy, sz);
        ins.addVertex(dx, dy, sz);
        ins.addVertex(dx, dy, dz);
        ins.addVertex(sx, dy, dz);
        ins.draw();

        // West
        ins.startDrawing(GL11.GL_LINE_LOOP);
        ins.setColorRGBA(r, g, b, a);
        ins.addVertex(sx, sy, sz);
        ins.addVertex(sx, dy, sz);
        ins.addVertex(sx, dy, dz);
        ins.addVertex(sx, sy, dz);
        ins.draw();

        // East
        ins.startDrawing(GL11.GL_LINE_LOOP);
        ins.setColorRGBA(r, g, b, a);
        ins.addVertex(dx, sy, sz);
        ins.addVertex(dx, dy, sz);
        ins.addVertex(dx, dy, dz);
        ins.addVertex(dx, sy, dz);
        ins.draw();

        // 元の描画環境へ戻す
        GL11.glPopMatrix();
        RenderHelper.enableStandardItemLighting();
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
}
