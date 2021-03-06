/*
 * Code Lyoko Mod for Minecraft ${version}
 * Copyright 2014 Cortex Modders, Matthew Warren, Jacob Rhoda, and other contributors.
 * Released under the MIT license http://opensource.org/licenses/MIT
 */

package net.cortexmodders.lyoko.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.cortexmodders.lyoko.CodeLyoko;
import net.cortexmodders.lyoko.items.ModItems;
import net.cortexmodders.lyoko.particle.LyokoParticleEffects;
import net.cortexmodders.lyoko.tileentity.TileEntityTower;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockTower extends BlockContainer
{
    public BlockTower()
    {
        // Material.iron
        super(Material.iron);
        // setCreativeTab
        this.setCreativeTab(CodeLyoko.LyokoTabs);
    }

    IIcon inside;

    @Override
    // registerIcons
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        // blockIcon
        this.blockIcon = par1IconRegister.registerIcon("lyoko:tower");
        this.inside = par1IconRegister.registerIcon("lyoko:computer_0");
    }

    @Override
    public TileEntity createNewTileEntity(World var1, int metadata)
    {
        return new TileEntityTower();
    }

    @SideOnly(Side.CLIENT)
    @Override
    // getIcon
    public IIcon getIcon(int side, int meta)
    {
        if (side == 2 && meta == 0)
            return this.inside;
        else if (side == 3 && meta == 2)
            return this.inside;
        else if (side == 4 && meta == 3)
            return this.inside;
        else if (side == 5 && meta == 1)
            return this.inside;
        return this.blockIcon;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        // getTileEntity - getTileEntity
        TileEntityTower tet = (TileEntityTower) world.getTileEntity(x, y, z);

        if (!world.isRemote)
            if (player.getHeldItem() != null && player.getHeldItem().getItem() == ModItems.laserArrow) {
                tet.owner = "reset";
                // markBlockForUpdate - markBlockForUpdate
                world.markBlockForUpdate(x, y, z);
                return true;
            }
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    // randomDisplayTick
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        // getTileEntity - getTileEntity
        TileEntityTower tet = (TileEntityTower) world.getTileEntity(x, y, z);

        int meta = world.getBlockMetadata(x, y, z);

        Random worldRand = world.rand;
        // 1/16th of a block - one 'pixel'
        double pixelWidth = 0.0625D;

        for (int side = 0; side < 6; ++side) {
            double x2 = x + worldRand.nextFloat();
            double y2 = y + worldRand.nextFloat();
            double z2 = z + worldRand.nextFloat();

            if (side == 0 && !world.getBlock(x, y + 1, z).isOpaqueCube())
                y2 = y + 1 + pixelWidth;

            if (side == 1 && !world.getBlock(x, y - 1, z).isOpaqueCube())
                y2 = y + 0 - pixelWidth;

            if (side == 2 && !world.getBlock(x, y, z + 1).isOpaqueCube() && meta != 2)
                z2 = z + 1 + pixelWidth;

            if (side == 3 && !world.getBlock(x, y, z - 1).isOpaqueCube() && meta != 0)
                z2 = z + 0 - pixelWidth;

            if (side == 4 && !world.getBlock(x + 1, y, z).isOpaqueCube() && meta != 1)
                x2 = x + 1 + pixelWidth;

            if (side == 5 && !world.getBlock(x - 1, y, z).isOpaqueCube() && meta != 3)
                x2 = x + 0 - pixelWidth;

            if (x2 < x || x2 > x + 1 || y2 < 0.0D || y2 > y + 1 || z2 < z || z2 > z + 1)
                if (tet.owner.equals("xana"))
                    LyokoParticleEffects.spawnParticle("xana", x2, y2, z2, 0.0D, 0.0D, 0.0D);
                else if (tet.owner.equals("lyoko"))
                    LyokoParticleEffects.spawnParticle("lyoko", x2, y2, z2, 0.0D, 0.0D, 0.0D);
                else if (tet.owner.equals("none"))
                    LyokoParticleEffects.spawnParticle("deactivated", x2, y2, z2, 0.0D, 0.0D, 0.0D);
                else if (tet.owner.equals("developer"))
                    LyokoParticleEffects.spawnParticle("dev", x2, y2, z2, 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    // onBlockPlacedBy
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLivingBase par5EntityLiving, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double(par5EntityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (l == 0)
            par1World.setBlockMetadataWithNotify(x, y, z, 0, 2);

        if (l == 1)
            par1World.setBlockMetadataWithNotify(x, y, z, 1, 2);

        if (l == 2)
            par1World.setBlockMetadataWithNotify(x, y, z, 2, 2);

        if (l == 3)
            par1World.setBlockMetadataWithNotify(x, y, z, 3, 2);
    }

}
