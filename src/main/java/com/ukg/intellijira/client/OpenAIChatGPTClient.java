package com.ukg.intellijira.client;

import com.ukg.intellijira.model.ChatGPTRequest;
import com.ukg.intellijira.model.ChatGPTResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "OpenAIChatGPTClient", url = "https://api.openai.com/v1")
public interface OpenAIChatGPTClient {

    @PostMapping(value = "/chat/completions", headers = {"Content-Type=application/json"})
    ChatGPTResponse chatCompletions(@RequestBody ChatGPTRequest chatGPTRequest,
                                    @RequestHeader("Authorization") String api_key);
}
