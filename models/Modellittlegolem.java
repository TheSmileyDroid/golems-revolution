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
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 1).addBox(-6.6F, 5.0F, -4.4F, 13.0F, 7.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(0, 1).addBox(-2.5F, 11.8F, -2.4F, 5.0F, 3.0F, 3.0F, 0.5F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, -1.0F);
		head.setTextureOffset(0, 1).addBox(-2.6F, -1.2F, -3.3F, 5.0F, 6.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(0, 1).addBox(-0.4F, 3.4F, -4.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		arm0 = new ModelRenderer(this);
		arm0.setRotationPoint(0.0F, -7.0F, 0.0F);
		arm0.setTextureOffset(0, 1).addBox(5.8F, 10.9F, -1.8F, 2.0F, 18.0F, 4.0F, 0.0F, false);

		arm1 = new ModelRenderer(this);
		arm1.setRotationPoint(-1.0F, -7.0F, 0.0F);
		arm1.setTextureOffset(0, 1).addBox(-7.4F, 10.9F, -1.8F, 2.0F, 18.0F, 4.0F, 0.0F, false);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(4.0F, 11.0F, 0.0F);
		leg0.setTextureOffset(0, 1).addBox(-3.5F, 3.0F, -1.8F, 4.0F, 10.0F, 3.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(-5.0F, 11.0F, 0.0F);
		leg1.setTextureOffset(0, 1).addBox(0.1F, 3.0F, -1.8F, 4.0F, 10.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg0.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg1.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.arm1.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.arm0.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		this.body.rotateAngleZ = f2 / 20.f;
	}
}