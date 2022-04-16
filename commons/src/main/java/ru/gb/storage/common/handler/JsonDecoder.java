package ru.gb.storage.common.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import ru.gb.storage.common.message.DateMessage;
import ru.gb.storage.common.message.Message;
import ru.gb.storage.common.message.TextMessage;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class JsonDecoder extends MessageToMessageDecoder<String> {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Override
    protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
        final byte[] bytes = msg.getBytes(StandardCharsets.UTF_8);
        System.out.println("Объект декодировки: " + bytes.toString());
        Message message = OBJECT_MAPPER.readValue(bytes, Message.class);
        out.add(message);
    }

}


