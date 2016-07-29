package sirttas.alchemytech.block.instrument.shaker;

import static sirttas.alchemytech.block.BlockAT.BIT_SIZE;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import sirttas.alchemytech.block.tile.renderer.InstrumentRenderer;
import sirttas.alchemytech.model.ShakerBarrelModel;

public class ShakerRenderer extends InstrumentRenderer<TileShaker> {

	private static final ResourceLocation IRON_TEXTURE = new ResourceLocation("alchemytech",
			"textures/blocks/iron.png");

	private ShakerBarrelModel barrel = new ShakerBarrelModel();

	@Override
	public void renderTileEntityAt(TileShaker te, double x, double y, double z, float partialTicks, int destroyStage) {
		barrel = new ShakerBarrelModel();
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x + 0.5f, (float) y + 0.5f, (float) z + 0.5f);
		bindTexture(IRON_TEXTURE);
		barrel.barrel.rotateAngleX = te.getProgress() % 20 / 10 * (float) Math.PI;
		barrel.render(null, 0, 0, 0, 0, 0, 0.0625F);
		GlStateManager.popMatrix();

		if (te.getStackInSlot(0) != null) {
			renderItem(te.getStackInSlot(0), x + 0.5, y + 8.5 * BIT_SIZE, z + 0.5, 0.5);
		}
	}

}
