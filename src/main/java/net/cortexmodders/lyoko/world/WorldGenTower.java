/*
 * Code Lyoko Mod for Minecraft ${version}
 * Copyright 2014 Cortex Modders, Matthew Warren, Jacob Rhoda, and other contributors.
 * Released under the MIT license http://opensource.org/licenses/MIT
 */

package net.cortexmodders.lyoko.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.cortexmodders.lyoko.lib.DimensionIds;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGenTower implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.dimensionId == DimensionIds.ICE || world.provider.dimensionId == DimensionIds.MOUNTAIN || world.provider.dimensionId == DimensionIds.FOREST || world.provider.dimensionId == DimensionIds.DESERT || world.provider.dimensionId == DimensionIds.CARTHAGE)
            this.generateTower(world, random, chunkX * 16, chunkZ * 16);
    }

    private void generateTower(World world, Random random, int blockX, int blockZ)
    {
        if (random.nextInt(10) == 0) {
            int x = blockX + random.nextInt(16);
            int z = blockZ + random.nextInt(16);
            int y = world.getHeightValue(x, z);

            new StructureTower().generate(world, random, x, y, z);
        }
    }
}
