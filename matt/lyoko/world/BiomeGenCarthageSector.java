package matt.lyoko.world;

import matt.lyoko.CodeLyoko;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.world.biome.SpawnListEntry;

public class BiomeGenCarthageSector extends BiomeGenBaseLyoko
{
    public BiomeGenCarthageSector(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 4, 4));
        this.topBlock = (byte)CodeLyoko.Lyoko_Carthage;
        this.fillerBlock = (byte)CodeLyoko.Lyoko_Carthage;
        
    }
}
