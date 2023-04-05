package com.ukg.intellijira.controller;

import com.ukg.intellijira.model.ChatGPTResponse;
import com.ukg.intellijira.model.StoryRequest;
import com.ukg.intellijira.model.StoryResponse;
import com.ukg.intellijira.service.IntelliJiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class IntelliJiraController {

    @Autowired
    private IntelliJiraService intelliJiraService;

    @PostMapping(value = "/stories", consumes = MediaType.APPLICATION_JSON_VALUE)
    public StoryResponse createStories(@RequestBody StoryRequest chatRequest){
        return intelliJiraService.createStories(chatRequest);
    }
}
