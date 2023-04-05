package com.ukg.intellijira.service;

import com.ukg.intellijira.client.OpenAIChatGPTClient;
import com.ukg.intellijira.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class IntelliJiraServiceImpl implements IntelliJiraService{

    @Autowired
    OpenAIChatGPTClient openAIChatGPTClient;

    @Override
    public StoryResponse createStories(StoryRequest chatRequest) {

        Message message = Message.builder().role("user").content(chatRequest.getQuery()).build();
        ChatGPTRequest chatGPTRequest = ChatGPTRequest.builder().model("gpt-3.5-turbo").messages(Collections.singletonList(message))
                .build();
        ChatGPTResponse chatGPTResponse = openAIChatGPTClient.chatCompletions(chatGPTRequest,
                "Bearer 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");
        AtomicReference<String> output = new AtomicReference<>("");
        chatGPTResponse.getChoices().stream().forEach(choice -> {
            log.info("{}", choice.getMessage());
            output.getAndSet( output.get() + choice.getMessage().getContent() );
        });

        StoryResponse storyResponse = new StoryResponse();

        storyResponse.setOutput(output.get());
        return storyResponse;
    }
}
