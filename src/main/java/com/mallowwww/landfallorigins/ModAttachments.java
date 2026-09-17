package com.mallowwww.landfallorigins;

import com.mallowwww.landfallorigins.attachment.OriginDataAttachment;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModAttachments {
    public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(
            NeoForgeRegistries.ATTACHMENT_TYPES, LandfallOrigins.MODID
    );

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<OriginDataAttachment>> ORIGIN_ATTACHMENT = ATTACHMENTS.register("origin_attachment",
            () -> AttachmentType.builder(OriginDataAttachment::create)
                    .serialize(OriginDataAttachment.CODEC)
                    .sync(OriginDataAttachment.STREAM_CODEC)
                    .build()
    );
}
