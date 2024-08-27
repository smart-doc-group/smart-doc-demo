package com.smartdoc.example.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartdoc.example.model.Message;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;

/**
 * @author yu 2024/8/23
 */
public class MessageDecoder implements Decoder.Text<Message> {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public Message decode(String s) throws DecodeException {
        try {
            return objectMapper.readValue(s, Message.class);
        } catch (Exception e) {
            throw new DecodeException(s, "Unable to decode text to Message", e);
        }
    }
    @Override
    public boolean willDecode(String s) {
        return (s != null);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
    }
    @Override
    public void destroy() {
    }
}
