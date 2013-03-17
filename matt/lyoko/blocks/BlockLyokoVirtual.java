package matt.lyoko.blocks;

import matt.lyoko.CodeLyoko;
import matt.lyoko.entities.TileEntityVirtualBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLyokoVirtual extends BlockContainer
{
	public BlockLyokoVirtual(int par1)
	{
		super(par1, Material.iron);
		this.setCreativeTab(CodeLyoko.LyokoTabs);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		if(world.provider.dimensionId != CodeLyoko.Polar_Sector_ID && world.provider.dimensionId != CodeLyoko.Mountain_Sector_ID
				&& world.provider.dimensionId != CodeLyoko.Forest_Sector_ID
				&& world.provider.dimensionId != CodeLyoko.Desert_Sector_ID
				&& world.provider.dimensionId != CodeLyoko.Carthage_Sector_ID)
		{
			world.func_96440_m(x, y, z, 0);
		}
	}
	
	private Icon virtualGrass;
	private Icon virtualStone;
	private Icon virtualSand;
	private Icon virtualIce;
	private Icon virtualCarthage;
	
	@Override
	public Icon getBlockTexture(IBlockAccess access, int x, int y, int z, int side)
    {
		if(access.getBlockTileEntity(x, y, z).worldObj.provider.dimensionId == CodeLyoko.Forest_Sector_ID)
		{
			return virtualGrass;
		}
		else if(access.getBlockTileEntity(x, y, z).worldObj.provider.dimensionId == CodeLyoko.Mountain_Sector_ID)
		{
			return virtualStone;
		}
		else if(access.getBlockTileEntity(x, y, z).worldObj.provider.dimensionId == CodeLyoko.Desert_Sector_ID)
		{
			return virtualSand;
		}
		else if(access.getBlockTileEntity(x, y, z).worldObj.provider.dimensionId == CodeLyoko.Polar_Sector_ID)
		{
			return virtualIce;
		}
		else if(access.getBlockTileEntity(x, y, z).worldObj.provider.dimensionId == CodeLyoko.Carthage_Sector_ID)
		{
			return virtualCarthage;
		}
        return virtualGrass;
    }
	
	@Override
	public void func_94332_a(IconRegister par1IconRegister)
	{
		virtualGrass = this.field_94336_cN = par1IconRegister.func_94245_a("lyoko:lyokograss");
		virtualStone = par1IconRegister.func_94245_a("lyoko:lyokostone");
		virtualSand  = par1IconRegister.func_94245_a("lyoko:lyokosand");
		virtualIce = par1IconRegister.func_94245_a("lyoko:lyokoice");
		virtualCarthage = par1IconRegister.func_94245_a("lyoko:carthage");
	}

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return new TileEntityVirtualBlock();
	}
}