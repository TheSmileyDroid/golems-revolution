package net.mcreator.golemsrevolution.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.golemsrevolution.entity.LittleGolemEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class LittleGolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LittleGolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modellittlegolem(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("golems_revolution:textures/littlegolem.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modellittlegolem extends EntityModel<Entity> {
		private final ModelRenderer body;
		private final ModelRenderer head;
		private final ModelRenderer arm0;
		private final ModelRenderer arm1;
		private final ModelRenderer leg0;
		private final ModelRenderer leg1;
		public Modellittlegolem() {
			textureWidth = 64;
			textureHeight = 64;
			body = new ModelRenderer(this);
			body.setRotationPoint(0.0F, 0.0F, 0.0F);
			body.setTextureOffset(0, 0).addBox(-6.6F, 5.0F, -4.4F, 13.0F, 7.0F, 7.0F, 0.0F, false);
			body.setTextureOffset(33, 0).addBox(-2.5F, 11.8F, -2.4F, 5.0F, 3.0F, 3.0F, 0.5F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, -1.0F);
			head.setTextureOffset(24, 14).addBox(-2.6F, -1.2F, -3.3F, 5.0F, 6.0F, 5.0F, 0.0F, false);
			head.setTextureOffset(0, 0).addBox(-0.4F, 3.4F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			arm0 = new ModelRenderer(this);
			arm0.setRotationPoint(0.0F, -7.0F, 0.0F);
			arm0.setTextureOffset(12, 14).addBox(5.8F, 10.9F, -1.8F, 2.0F, 18.0F, 4.0F, 0.0F, false);
			arm1 = new ModelRenderer(this);
			arm1.setRotationPoint(-1.0F, -7.0F, 0.0F);
			arm1.setTextureOffset(0, 14).addBox(-7.4F, 10.9F, -1.8F, 2.0F, 18.0F, 4.0F, 0.0F, false);
			leg0 = new ModelRenderer(this);
			leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
			leg0.setTextureOffset(35, 35).addBox(-3.5F, 3.0F, -1.8F, 4.0F, 10.0F, 3.0F, 0.0F, false);
			leg1 = new ModelRenderer(this);
			leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
			leg1.setTextureOffset(24, 25).addBox(0.1F, 3.0F, -1.8F, 4.0F, 10.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			body.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
			arm0.render(matrixStack, buffer, packedLight, packedOverlay);
			arm1.render(matrixStack, buffer, packedLight, packedOverlay);
			leg0.render(matrixStack, buffer, packedLight, packedOverlay);
			leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.arm0.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
