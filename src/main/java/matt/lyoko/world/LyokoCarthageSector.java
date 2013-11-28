/*
 * Code Lyoko Mod for Minecraft v@VERSION
 * Copyright 2013 Cortex Modders, Matthew Warren, Jacob Rhoda, and
 * other contributors.
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 */

package matt.lyoko.world;

import matt.lyoko.CodeLyoko;
import matt.lyoko.lib.DimensionIds;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LyokoCarthageSector extends WorldProvider
{

    public int getDimensionID()
    {
        return DimensionIds.CARTHAGE;
    }

    @Override
    public void registerWorldChunkManager()
    {
        this.worldChunkMgr = new WorldChunkManagerHell(CodeLyoko.lyokocarthage, 0.8F, 0F);
    }

    public IChunkProvider getChunkProvider()
    {
        return new LyokoCarthageChunkProvider(this.worldObj, this.worldObj.getSeed(), this.hasNoSky);
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    // Ender sky if set true
    public boolean renderEndSky()
    {
        return true;
    }

    public float setSunSize()
    {
        return 1.0F;
    }

    public float setMoonSize()
    {
        return 1.0F;
    }

    // Darken the sky if it rains is true
    public boolean darkenSkyDuringRain()
    {
        return false;
    }

    // Star brightness 1.0F lets you see stars in day
    public float getStarBrightness(World world, float f)
    {
        return 1.0F;
    }

    // Fog Color
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3 getFogColor(float par1, float par2)
    {
        int var3 = 10518688;
        float var4 = MathHelper.cos(par1 * (float) Math.PI * 2.0F) * 2.0F + 0.5F;

        if (var4 < 0.0F)
            var4 = 0.0F;

        if (var4 > 1.0F)
            var4 = 1.0F;

        float var5 = (var3 >> 16 & 255) / 255.0F;
        float var6 = (var3 >> 8 & 255) / 255.0F;
        float var7 = (var3 & 255) / 255.0F;
        var5 *= var4 * 0.0F + 0.15F;
        var6 *= var4 * 0.0F + 0.15F;
        var7 *= var4 * 0.0F + 0.15F;
        return this.worldObj.getWorldVec3Pool().getVecFromPool(var5, var6, var7);
    }

    // removes clouds if set to false
    public boolean renderClouds()
    {
        return true;
    }

    @Override
    public String getDimensionName()
    {
        return "Carthage Sector";
    }

    @Override
    public int getAverageGroundLevel()
    {
        return 50;
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }

}
