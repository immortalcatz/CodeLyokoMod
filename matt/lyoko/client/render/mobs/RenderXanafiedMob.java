/*
 * Code Lyoko Mod for Minecraft v@VERSION
 *
 * Copyright 2013 Cortex Modders, Matthew Warren, Jacob Rhoda, and
 * other contributors.
 * Released under the MIT license
 * http://opensource.org/licenses/MIT
 * 
 */

package matt.lyoko.client.render.mobs;

import matt.lyoko.client.model.mobs.ModelBlok;
import matt.lyoko.entities.mobs.EntityXanafiedMob;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderXanafiedMob extends RendererLivingEntity
{
    private static ResourceLocation texture = new ResourceLocation("lyoko:textures/models/blok.png");
    
    public RenderXanafiedMob()
    {
		super(new ModelBlok(), 0.5F);
	}
    
    @Override
    protected ResourceLocation func_110775_a(Entity entity)
    {
        return this.texture;
    }
    
    @Override
    public void func_130000_a(EntityLivingBase ent, double par2, double par4, double par6, float par8, float par9)
    {
    	EntityXanafiedMob xana = (EntityXanafiedMob) ent;
    	if(xana != null && xana.infectedMob != null)
    	{
    		RendererLivingEntity render = (RendererLivingEntity) RenderManager.instance.getEntityRenderObject(xana.infectedMob);
    		render.func_130000_a(xana, par2, par4, par6, par8, par9);
    	}
    	else
    		super.func_130000_a(ent, par2, par4, par6, par8, par9);
    }
}