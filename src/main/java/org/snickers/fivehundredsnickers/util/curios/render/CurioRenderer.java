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
    private final BakedModel model;

    public CurioRenderer() {
        model = Minecraft.getInstance().getModelManager().getModel(new ResourceLocation(FiveHundredSnickers.MOD_ID, "item/stogie_2d"));

    }

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
            matrixStack.scale(1, 1, 1);
//            Quaternionf rotation = new Quaternionf(1, 1, 1, 1);

//            matrixStack.mulPose(rotation);
//            matrixStack.translate(0, 0.5, 0);
            renderer.render(stack, ItemDisplayContext.NONE, false, matrixStack, renderTypeBuffer, light, OverlayTexture.NO_OVERLAY, model1);
        }
    }


//    @Override
//    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack,
//                                                                          SlotContext slotContext, PoseStack matrixStack,
//                                                                          RenderLayerParent<T, M> renderLayerParent,
//                                                                          MultiBufferSource renderTypeBuffer, int light,
//                                                                          float limbSwing, float limbSwingAmount, float partialTicks,
//                                                                          float ageInTicks, float netHeadYaw, float headPitch) {
//        LivingEntity entity = slotContext.entity();
//
//
//        if (entity.level().isClientSide && !Minecraft.getInstance().options.getCameraType().isFirstPerson()) {
//            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
////            BakedModel model1 = itemRenderer.getModel(stack, entity.level(), entity, 0);
//            BakedModel model = Minecraft.getInstance().getModelManager().getModel(new ResourceLocation("minecraft","item/stick"));
//            //it can't find the correct model and uses placeholder instead
//            FiveHundredSnickers.LOGGER.info(String.valueOf(model.equals(Minecraft.getInstance().getModelManager().getMissingModel())));
//
//            matrixStack.pushPose();
//            matrixStack.scale(1, 1, 1);
////            matrixStack.translate(0, netHeadYaw, headPitch);
//
//            itemRenderer.render(stack, ItemDisplayContext.GROUND, false, matrixStack, renderTypeBuffer, light, OverlayTexture.NO_OVERLAY, model);
//            matrixStack.popPose();
//        }
//    }
}
