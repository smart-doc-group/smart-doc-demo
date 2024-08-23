package com.smartdoc.example.controller;

import com.smartdoc.example.decoder.MessageDecoder;
import com.smartdoc.example.encoder.MessageEncoder;
import com.smartdoc.example.model.Message;
import com.smartdoc.example.response.SampleResponse;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 * WebSocket server endpoint example.
 */
@Component
@ServerEndpoint(value = "/ws/chat/{userId}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class ChatEndpoint {

    /**
     * Called when a new connection is established.
     *
     * @param session the client session
     * @param userId  the user ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        System.out.println("Connected: " + session.getId() + ", User ID: " + userId);
    }

    /**
     * Called when a message is received from the client.
     *
     * @param message the message sent by the client
     * @param session the client session
     * @return the response message
     */
    @OnMessage
    public SampleResponse receiveMessage(Message message, Session session) {
        System.out.println("Received message: " + message);
        return new SampleResponse(message.getContent());
    }

    /**
     * Called when the connection is closed.
     *
     * @param session the client session
     */
    @OnClose
    public void onClose(Session session) {
        System.out.println("Disconnected: " + session.getId());
    }

    /**
     * Called when an error occurs.
     *
     * @param session   the client session
     * @param throwable the error
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }
}
