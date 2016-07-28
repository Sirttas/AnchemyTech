package sirttas.alchemytech.block.instrument.shaker;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirttas.alchemytech.block.instrument.shaker.ConfigShaker.NBT;
import sirttas.alchemytech.block.tile.instrument.TileInstrument;
import sirttas.alchemytech.helpers.NBTHelper;
import sirttas.alchemytech.item.ATItems;

public class TileShaker extends TileInstrument {

	ItemStack slot;

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return new int[] { 0 };
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return index == 0;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return index == 0;
	}

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index == 0) {
			return slot;
		}
		return null;
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		if (index == 0) {
			ItemStack ret = slot;

			slot = null;
			return ret;
		}
		return null;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index == 0) {
			slot = stack;
		}

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return stack.getItem() == ATItems.preparation && index == 0;
	}

	@Override
	public void clear() {
		super.clear();
		slot = null;

	}

	@Override
	public String getName() {
		return ConfigShaker.UNLOCALIZED_NAME;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		slot = NBTHelper.readItemStack(compound, NBT.SLOT);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		NBTHelper.writeItemStack(compound, NBT.SLOT, slot);
		return compound;
	}

	@Override
	@SideOnly(Side.CLIENT)
	protected void clientUpdate() {
		if (progress > 0) {
			progress++;
		}
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		super.onDataPacket(net, packet);
	}

}
