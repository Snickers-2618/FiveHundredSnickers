package org.snickers.fivehundredsnickers.util.curios.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.joml.Quaternionf;
import org.snickers.fivehundredsnickers.FiveHundredSnickers;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class CurioRenderer  implements ICurioRenderer {
    public CurioRenderer() {}

    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack,
                                                                          SlotContext slotContext, PoseStack matrixStack,
                                                                          RenderLayerParent<T, M> renderLayerParent,
                                                                          MultiBufferSource renderTypeBuffer, int light,
                                                                          float limbSwing, float limbSwingAmount, float partialTicks,
                                                                          float ageInTicks, float netHeadYaw, float headPitch) {
        LivingEntity entity = slotContext.entity();

        if (entity.level().isClientSide && !Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
            ItemRenderer renderer = Minecraft.getInstance().getItemRenderer();
            BakedModel model1 = renderer.getModel(stack, entity.level(), entity, 0);

            Quaternionf pitch = new Quaternionf().rotateX((float) Math.toRadians(headPitch-90));
            Quaternionf yaw = new Quaternionf().rotateY((float) Math.toRadians(netHeadYaw));

            Quaternionf rotation = yaw.mul(pitch).rotateZ((float) Math.toRadians(17)).rotateX((float) Math.toRadians(3));
            matrixStack.rotateAround(rotation, 0, 0, 0.0f);
            matrixStack.scale(1, 1, 1);
            matrixStack.translate(0, 0.3, -0.09375);

            renderer.render(stack, ItemDisplayContext.NONE, false, matrixStack, renderTypeBuffer, light, OverlayTexture.NO_OVERLAY, model1);
        }
    }

    //freaky cock rotation
//            Quaternionf rotation = new Quaternionf(-1, 0, 0, (headPitch/90)+1);
//            matrixStack.rotateAround(rotation, 0, 0.5f, 0.1f);
//            matrixStack.scale(1, 1, 1);
//            matrixStack.translate(0, 0.5, 0.1);

}
