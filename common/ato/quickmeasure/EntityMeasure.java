package ato.quickmeasure;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

/**
 * レンダリングを行うため、プレイヤーに追従するエンティティを作成
 * EntitySpawnChecker を参考にした
 */
@SideOnly(Side.CLIENT)
public class EntityMeasure extends Entity {

    /**
     * グリッドの間隔
     */
    private final int span;
    /**
     * スタート位置
     */
    private final int startX, startY, startZ;

    public EntityMeasure(World par1World, int span) {
        super(par1World);

        this.span = span;
        resetPos();
        this.startX = (int)this.posX;
        this.startY = (int)this.posY;
        this.startZ = (int)this.posZ;
    }

    @Override
    protected void entityInit() {
        setSize(0.5f, 0.5f);
        resetPos();
    }

    @Override
    public void onEntityUpdate() {
        resetPos();
    }

    /**
     * エンティティを破棄する
     */
    public void destroy() {
        isDead = true;
    }

    /**
     * エンティティの位置のプレイヤーの位置へと飛ばす
     */
    private void resetPos() {
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
        if (player != null) {
            super.setPosition(player.posX, player.posY, player.posZ);
        }
    }

    // 機能の無効化

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
    }

    @Override
    public void setDead() {
    }

    @Override
    public void setFire(int par1) {
    }

    @Override
    public boolean isBurning() {
        return false;
    }

    @Override
    public void mountEntity(Entity par1Entity) {
    }

    @Override
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
        return false;
    }

    @Override
    public void moveEntity(double par1, double par3, double par5) {
    }

    @Override
    public void applyEntityCollision(Entity entity) {
    }

    @Override
    public float getShadowSize() {
        return 0.0f;
    }

    @Override
    public boolean isOffsetPositionInLiquid(double x, double y, double z) {
        return false;
    }

    @Override
    public void onStruckByLightning(EntityLightningBolt lb) {
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    @Override
    public void setPosition(double x, double y, double z) {
        resetPos();
    }

    @Override
    public void setAngles(float yaw, float pitch) {
    }

    @Override
    public int getBrightnessForRender(float partialTickTime) {
        // ライトマップの明るさを最大に
        return 0xf00000;
    }

    @Override
    public float getBrightness(float partialTickTime) {
        return 0.0f;
    }
}
