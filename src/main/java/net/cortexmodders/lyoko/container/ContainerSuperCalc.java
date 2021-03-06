/*
 * Code Lyoko Mod for Minecraft ${version}
 * Copyright 2014 Cortex Modders, Matthew Warren, Jacob Rhoda, and other contributors.
 * Released under the MIT license http://opensource.org/licenses/MIT
 */

package net.cortexmodders.lyoko.container;

import net.cortexmodders.lyoko.items.ItemLyokoFuel;
import net.cortexmodders.lyoko.items.ModItems;
import net.cortexmodders.lyoko.slots.SlotSuperCalc;
import net.cortexmodders.lyoko.slots.SlotSuperCalcFuel;
import net.cortexmodders.lyoko.tileentity.TileEntitySuperCalc;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSuperCalc extends Container
{
    protected TileEntitySuperCalc tileEntity;

    public ContainerSuperCalc(InventoryPlayer inventoryPlayer, TileEntitySuperCalc te)
    {
        this.tileEntity = te;

        // the Slot constructor takes the IInventory and the slot number in that
        // it binds to
        // and the x-y coordinates it resides on-screen
        this.addSlotToContainer(new SlotSuperCalcFuel(this, this.tileEntity, 0, 58, 20));
        this.addSlotToContainer(new SlotSuperCalc(this, this.tileEntity, 1, 145, 38));

        // commonly used vanilla code that adds the player's inventory
        this.bindPlayerInventory(inventoryPlayer);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return this.tileEntity.isUseableByPlayer(player);
    }

    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 71 + i * 18));

        for (int i = 0; i < 9; i++)
            this.addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 129));
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int slotId)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(slotId);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (slotId == 1) {
                if (!this.mergeItemStack(itemstack1, 2, 38, true))
                    return null;

                slot.onSlotChange(itemstack1, itemstack);
            } else if (slotId != 0) {
                if (itemstack1 != null && itemstack1.getItem() != null && (itemstack1.getItem() instanceof ItemLyokoFuel || itemstack1.getItem().equals(ModItems.laserArrow))) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                        return null;
                } else if (slotId >= 2 && slotId < 29) {
                    if (!this.mergeItemStack(itemstack1, 29, 38, false))
                        return null;
                } else if (slotId >= 29 && slotId < 38 && !this.mergeItemStack(itemstack1, 2, 29, false))
                    return null;
            } else if (!this.mergeItemStack(itemstack1, 2, 38, false))
                return null;

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack) null);
            else
                slot.onSlotChanged();

            if (itemstack1.stackSize == itemstack.stackSize)
                return null;

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}
