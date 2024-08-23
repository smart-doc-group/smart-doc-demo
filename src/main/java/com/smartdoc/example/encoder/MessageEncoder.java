package com.smartdoc.example.encoder;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartdoc.example.response.SampleResponse;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;

/**
 * @author yu 2024/8/23
 */
public class MessageEncoder implements Encoder.Text<SampleResponse> {

  private static final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public String encode(SampleResponse response) {
    try {
      return objectMapper.writeValueAsString(response);
    } catch (Exception e) {
      throw new RuntimeException("Unable to encode SampleResponse", e);
    }
  }

  @Override
  public void init(EndpointConfig endpointConfig) {
  }

  @Override
  public void destroy() {
  }
}

