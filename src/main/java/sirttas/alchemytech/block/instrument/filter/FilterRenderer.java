package sirttas.alchemytech.block.instrument.filter;

import static sirttas.alchemytech.block.BlockAT.BIT_SIZE;

import sirttas.alchemytech.block.tile.renderer.InstrumentRenderer;

public class FilterRenderer extends InstrumentRenderer<TileFilter> {

	@Override
	public void renderTileEntityAt(TileFilter te, double x, double y, double z, float partialTicks, int destroyStage) {
		if (te.getStackInSlot(0) != null) {
			renderItem(te.getStackInSlot(0), x + 0.475, y + 6 * BIT_SIZE, z + 0.475, 0.5);
		}
	}

}
