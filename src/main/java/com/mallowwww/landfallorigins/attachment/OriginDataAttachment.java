package com.mallowwww.landfallorigins.attachment;

import com.mallowwww.landfallorigins.LandfallOrigins;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.attachment.AttachmentType;

import java.util.Arrays;

public record OriginDataAttachment(ResourceLocation origin, Boolean[] unlockedAbilities) {
    public static final Codec<OriginDataAttachment> CODEC = RecordCodecBuilder.create(i -> i.group(
            ResourceLocation.CODEC.fieldOf("origin").forGetter(OriginDataAttachment::origin),
            Codec.BOOL.listOf().fieldOf("unlockedAbilities").forGetter((OriginDataAttachment attachment) -> Arrays.asList(attachment.unlockedAbilities))
    ).apply(i, (origin, unlockedAbilities) -> {
        Boolean[] arr = new Boolean[5];
        for (int j = 0; j < 4; j++) {
            arr[j] = unlockedAbilities.get(j);
        }
        return new OriginDataAttachment(origin, arr);
    }));
    public static final StreamCodec<FriendlyByteBuf, OriginDataAttachment> STREAM_CODEC = new StreamCodec<FriendlyByteBuf, OriginDataAttachment>() {

        @Override
        public void encode(FriendlyByteBuf buffer, OriginDataAttachment value) {
            buffer.writeResourceLocation(value.origin);
            byte one = 1;
            byte zero = 0;
            byte[] encoded = new byte[5];
            for (int i = 0; i < 5; i++) {
                encoded[i] = value.unlockedAbilities[i] ? one : zero;
            }
            buffer.writeByteArray(encoded);
        }

        @Override
        public OriginDataAttachment decode(FriendlyByteBuf buffer) {
            ResourceLocation location = buffer.readResourceLocation();
            byte[] arr = buffer.readByteArray(5);
            Boolean[] unlockedAbilities = new Boolean[5];
            for (int i = 0; i < 5; i++) {
                unlockedAbilities[i] = arr[i] == 1;
            }
            return new OriginDataAttachment(location, unlockedAbilities);
        }
    };

    public static OriginDataAttachment create() {
        return new OriginDataAttachment(LandfallOrigins.path("none"), new Boolean[5]);

    }
}
