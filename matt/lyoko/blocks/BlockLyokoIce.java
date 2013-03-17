package matt.lyoko.blocks;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.*;
import java.util.Random;
import matt.lyoko.*;

public class BlockLyokoIce extends BlockBreakable
{
	public BlockLyokoIce(int par1, String par2, Material material, boolean flag)
	{
		super(par1, par2, material, flag);
		this.setCreativeTab(CodeLyoko.LyokoTabs);
		this.setBlockUnbreakable();
		
	}
	
	@Override
	public void func_94332_a(IconRegister par1IconRegister)
	{
		this.field_94336_cN = par1IconRegister.func_94245_a("lyoko:lyokoice");
	}
	
	public int getRenderBlockPass()
    {
        return 1;
    }
	
	public int quantityDropped(Random par1Random)
	{
		return 1;
	}
}