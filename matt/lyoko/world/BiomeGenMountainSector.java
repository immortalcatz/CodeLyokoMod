package matt.lyoko.world;

import matt.lyoko.lib.BlockIds;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenMountainSector extends BiomeGenBaseLyoko
{
    public BiomeGenMountainSector(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)BlockIds.LYOKO_STONE;
        this.fillerBlock = (byte)BlockIds.LYOKO_STONE;
    }
}
