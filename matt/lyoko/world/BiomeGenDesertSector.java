package matt.lyoko.world;

import matt.lyoko.CodeLyoko;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenDesertSector extends BiomeGenBaseLyoko
{
    public BiomeGenDesertSector(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)CodeLyoko.Lyoko_Sand;
        this.fillerBlock = (byte)CodeLyoko.Lyoko_Sand;
    }
}
