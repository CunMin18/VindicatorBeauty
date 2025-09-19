// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package org.cunmin18.vindicator_beauty.client.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import org.cunmin18.vindicator_beauty.client.animations.ModAnimations;
import org.cunmin18.vindicator_beauty.entities.VindicatorBeautyEntity;

public class VindicatorBeautyEntityModel<T extends VindicatorBeautyEntity> extends SinglePartEntityModel<T> {
	private final ModelPart VindicatorBeauty;
	private final ModelPart Body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Head;
	private final ModelPart Hair;
	private final ModelPart hair_g2;
	private final ModelPart hair_g1;
	private final ModelPart Hair_Ring2;
	private final ModelPart Hair_Ring;
	private final ModelPart LowerBody;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	public VindicatorBeautyEntityModel(ModelPart root) {

        //这个Blockbench导出模型有问题,所以手动修改了一下
		this.VindicatorBeauty = root.getChild("VindicatorBeauty");
		this.Body = VindicatorBeauty.getChild("Body");
		this.RightArm = Body.getChild("RightArm");
		this.LeftArm = Body.getChild("LeftArm");
		this.Head = VindicatorBeauty.getChild("Head");
		this.Hair = Head.getChild("Hair");
		this.hair_g2 = Hair.getChild("hair_g2");
		this.hair_g1 = Hair.getChild("hair_g1");
		this.Hair_Ring2 = Hair.getChild("Hair_Ring2");
		this.Hair_Ring = Hair.getChild("Hair_Ring");
		this.LowerBody = VindicatorBeauty.getChild("LowerBody");
		this.RightLeg = LowerBody.getChild("RightLeg");
		this.LeftLeg = LowerBody.getChild("LeftLeg");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData VindicatorBeauty = modelPartData.addChild("VindicatorBeauty", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Body = VindicatorBeauty.addChild("Body", ModelPartBuilder.create().uv(38, 43).cuboid(-1.5F, 0.0F, 1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(42, 28).cuboid(-2.0F, 2.0F, 1.0F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(28, 23).cuboid(-3.0F, 4.0F, 0.5F, 5.0F, 2.0F, 3.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-4.0F, 6.0F, 0.0F, 7.0F, 3.0F, 4.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-5.0F, 8.0F, -1.0F, 9.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, -1.0F));

		ModelPartData Body_C1_r1 = Body.addChild("Body_C1_r1", ModelPartBuilder.create().uv(46, 19).cuboid(-1.0F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 4.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData RightArm = Body.addChild("RightArm", ModelPartBuilder.create(), ModelTransform.of(-2.5F, 2.0F, 2.0F, 0.0F, 0.0F, 2.5307F));

		ModelPartData RightArm_r1 = RightArm.addChild("RightArm_r1", ModelPartBuilder.create().uv(46, 11).cuboid(0.25F, -7.0F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.5F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5708F));

		ModelPartData Seelve_Right_r1 = RightArm.addChild("Seelve_Right_r1", ModelPartBuilder.create().uv(0, 46).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData LeftArm = Body.addChild("LeftArm", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 4.0F, 2.0F));

		ModelPartData LeftLeg_r1 = LeftArm.addChild("LeftLeg_r1", ModelPartBuilder.create().uv(26, 45).cuboid(0.5F, -7.0F, -0.5F, 1.0F, 7.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, 3.0F, 0.0F, 0.0F, 0.0F, -1.0908F));

		ModelPartData Seelve_Left_r1 = LeftArm.addChild("Seelve_Left_r1", ModelPartBuilder.create().uv(18, 45).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData Head = VindicatorBeauty.addChild("Head", ModelPartBuilder.create().uv(0, 35).cuboid(-2.0F, -4.0F, 0.0F, 3.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -16.0F, 0.0F));

		ModelPartData Nose_r1 = Head.addChild("Nose_r1", ModelPartBuilder.create().uv(24, 30).cuboid(-1.0F, -1.5F, 0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, -1.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData Hair = Head.addChild("Hair", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 0.0F));

		ModelPartData hair_r1 = Hair.addChild("hair_r1", ModelPartBuilder.create().uv(10, 35).cuboid(0.0F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -3.0F, -1.0F, -0.1745F, 0.0F, 0.0F));

		ModelPartData Hair1_r1 = Hair.addChild("Hair1_r1", ModelPartBuilder.create().uv(34, 33).cuboid(0.0F, 1.0F, 0.0F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -4.5F, 2.5F, -1.4399F, -0.4363F, 0.0F));

		ModelPartData Hair1_r2 = Hair.addChild("Hair1_r2", ModelPartBuilder.create().uv(14, 23).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.5F, 0.5F, -1.1781F, -0.0436F, -0.2618F));

		ModelPartData Hair1_r3 = Hair.addChild("Hair1_r3", ModelPartBuilder.create().uv(30, 0).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -3.5F, -0.5F, -1.4399F, -0.0436F, 0.2182F));

		ModelPartData Hair1_long_r1 = Hair.addChild("Hair1_long_r1", ModelPartBuilder.create().uv(18, 14).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.5F, -0.5F, -1.5708F, -0.7854F, -0.2618F));

		ModelPartData Hair1_long_r2 = Hair.addChild("Hair1_long_r2", ModelPartBuilder.create().uv(0, 14).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -1.5F, -0.5F, -1.7017F, 0.0F, 0.1745F));

		ModelPartData Hair1_r4 = Hair.addChild("Hair1_r4", ModelPartBuilder.create().uv(0, 23).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -3.5F, -0.5F, -1.4399F, -0.0436F, -0.2182F));

		ModelPartData Hair1_r5 = Hair.addChild("Hair1_r5", ModelPartBuilder.create().uv(0, 41).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -1.5F, 2.5F, -1.4399F, -0.0436F, 0.0436F));

		ModelPartData Hair1_r6 = Hair.addChild("Hair1_r6", ModelPartBuilder.create().uv(20, 40).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -1.5F, 2.5F, -1.4399F, -0.0436F, 0.0F));

		ModelPartData Hair1_r7 = Hair.addChild("Hair1_r7", ModelPartBuilder.create().uv(0, 30).cuboid(-2.0F, 0.0F, 0.0F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -4.5F, 2.5F, -1.4835F, 0.0873F, 0.0F));

		ModelPartData Hair1_r8 = Hair.addChild("Hair1_r8", ModelPartBuilder.create().uv(22, 7).cuboid(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -4.5F, 2.5F, -1.4835F, 0.0F, 0.0F));

		ModelPartData Hair1_r9 = Hair.addChild("Hair1_r9", ModelPartBuilder.create().uv(36, 19).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -4.5F, 0.5F, 0.0F, 0.0436F, -0.0436F));

		ModelPartData Hair1_r10 = Hair.addChild("Hair1_r10", ModelPartBuilder.create().uv(28, 28).cuboid(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -4.5F, -0.5F, -0.0436F, 0.0436F, 0.0F));

		ModelPartData Hair1_r11 = Hair.addChild("Hair1_r11", ModelPartBuilder.create().uv(18, 49).cuboid(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.5F, -2.5F, 0.5F, -1.5708F, 0.0F, -0.3491F));

		ModelPartData Hair1_r12 = Hair.addChild("Hair1_r12", ModelPartBuilder.create().uv(42, 0).cuboid(0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-5.5F, -2.5F, 0.5F, -1.5708F, 0.0F, 0.1309F));

		ModelPartData Hair1_r13 = Hair.addChild("Hair1_r13", ModelPartBuilder.create().uv(48, 8).cuboid(-0.3F, -0.5F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -2.5F, 0.5F, -1.5708F, 0.0F, 0.0F));

		ModelPartData hair_g2 = Hair.addChild("hair_g2", ModelPartBuilder.create(), ModelTransform.of(-3.5F, -1.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		ModelPartData Hair1_r14 = hair_g2.addChild("Hair1_r14", ModelPartBuilder.create().uv(10, 37).cuboid(-0.7F, -1.5F, -0.5F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -1.0F, 0.0873F, 0.0F, 0.0F));

		ModelPartData Hair1_r15 = hair_g2.addChild("Hair1_r15", ModelPartBuilder.create().uv(24, 33).cuboid(-1.0F, -2.5F, -1.0F, 1.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 1.0F, -1.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData Hair1_r16 = hair_g2.addChild("Hair1_r16", ModelPartBuilder.create().uv(34, 38).cuboid(0.0F, -0.5436F, -1.999F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.1309F));

		ModelPartData hair_g1 = Hair.addChild("hair_g1", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -1.5F, -0.5F));

		ModelPartData Hair1_r17 = hair_g1.addChild("Hair1_r17", ModelPartBuilder.create().uv(36, 13).cuboid(-0.5F, -1.5F, -0.5F, 1.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, -1.0F, -1.0F, 0.0436F, -0.0436F, 0.0F));

		ModelPartData Hair1_r18 = hair_g1.addChild("Hair1_r18", ModelPartBuilder.create().uv(14, 30).cuboid(-1.0F, -2.5F, -0.5F, 1.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 1.0F, -1.0F, 0.1309F, 0.0F, 0.0F));

		ModelPartData Hair1_r19 = hair_g1.addChild("Hair1_r19", ModelPartBuilder.create().uv(38, 6).cuboid(0.0F, -0.5F, -1.0F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		ModelPartData Hair_Ring2 = Hair.addChild("Hair_Ring2", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -6.5F, 1.5F));

		ModelPartData Hair1_ring_r1 = Hair_Ring2.addChild("Hair1_ring_r1", ModelPartBuilder.create().uv(30, 43).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.0873F, -1.5708F, 0.0F));

		ModelPartData Hair1_ring_r2 = Hair_Ring2.addChild("Hair1_ring_r2", ModelPartBuilder.create().uv(48, 5).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 2.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData Hair1_ring_r3 = Hair_Ring2.addChild("Hair1_ring_r3", ModelPartBuilder.create().uv(10, 43).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -1.0F, 0.0F, -1.4835F, 0.0F, 0.0F));

		ModelPartData Hair1_ring_r4 = Hair_Ring2.addChild("Hair1_ring_r4", ModelPartBuilder.create().uv(36, 47).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData Hair_Ring = Hair.addChild("Hair_Ring", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -6.5F, 1.5F));

		ModelPartData Hair1_ring_r5 = Hair_Ring.addChild("Hair1_ring_r5", ModelPartBuilder.create().uv(12, 47).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, 0.0F, 0.0F, -1.5708F, -0.0436F));

		ModelPartData Hair1_ring_r6 = Hair_Ring.addChild("Hair1_ring_r6", ModelPartBuilder.create().uv(46, 35).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 2.0F, 0.0F, 0.0F, -1.5708F, -0.0436F));

		ModelPartData Hair1_ring_r7 = Hair_Ring.addChild("Hair1_ring_r7", ModelPartBuilder.create().uv(30, 47).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, 0.0F, 0.0F, -1.5272F, -0.0873F, 0.0F));

		ModelPartData Hair1_ring_r8 = Hair_Ring.addChild("Hair1_ring_r8", ModelPartBuilder.create().uv(46, 32).cuboid(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -1.5708F, 0.0873F, 0.0F));

		ModelPartData LowerBody = VindicatorBeauty.addChild("LowerBody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData RightLeg = LowerBody.addChild("RightLeg", ModelPartBuilder.create().uv(8, 47).cuboid(-2.0F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(30, 40).cuboid(-2.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 38).cuboid(-2.0F, 2.0F, -2.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 1.0F));

		ModelPartData LeftLeg = LowerBody.addChild("LeftLeg", ModelPartBuilder.create().uv(46, 42).cuboid(0.0F, -6.0F, -0.5F, 1.0F, 6.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 37).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F))
		.uv(44, 23).cuboid(0.0F, 2.0F, -2.5F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -3.0F, 1.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		VindicatorBeauty.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart getPart() {
        return VindicatorBeauty;
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017453292F;
        this.Head.pitch = headPitch * 0.017453292F;
    }
    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        var accurateSize = entity.isBaby() ? 0.7f : 1.35f;
        System.out.println(accurateSize);

        //调整模型大小
        magScale(accurateSize,VindicatorBeauty);
        magScale((!entity.isBaby() ? 1 : 1.35f),Head);

        if (limbDistance <= 0.01F) {
            float breathing = MathHelper.sin(animationProgress * 0.1F) * 0.05F;
            Body.pitch = breathing;
            Hair.pitch = Head.pitch + breathing * 0.5F;
        }
        this.setHeadAngles(headYaw, headPitch);
        this.animateMovement(ModAnimations.VINDICATOR_BEAUTY_WALK, limbAngle, limbDistance, 2f, 2.5f);
    }
    private void magScale(float num,ModelPart part){
        part.xScale *= num;
        part.yScale *= num;
        part.zScale *= num;
    }
}