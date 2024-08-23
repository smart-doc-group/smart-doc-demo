package com.smartdoc.example.response;

/**
 * @author yu 2024/8/23
 */
public class SampleResponse {
    private String responseContent;

    public SampleResponse(String responseContent) {
        this.responseContent = responseContent;
    }

    public String getResponseContent() {
        return responseContent;
    }

    public void setResponseContent(String responseContent) {
        this.responseContent = responseContent;
    }
}
