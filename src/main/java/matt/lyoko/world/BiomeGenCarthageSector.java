/*
 * Code Lyoko Mod for Minecraft v@VERSION
 * Copyright 2013 Cortex Modders, Matthew Warren, Jacob Rhoda, and
 * other contributors.
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 */

package matt.lyoko.world;

import matt.lyoko.blocks.ModBlocks;

public class BiomeGenCarthageSector extends BiomeGenBaseLyoko
{
    public BiomeGenCarthageSector(int par1)
    {
        super(par1);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.topBlock = (byte) ModBlocks.SectorBlock.blockID;
        this.fillerBlock = (byte) ModBlocks.SectorBlock.blockID;
        this.setBiomeName("Carthage");
        
        this.waterColorMultiplier = 0xE42D14;
    }
}
