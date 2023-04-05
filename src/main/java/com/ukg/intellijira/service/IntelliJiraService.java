package com.ukg.intellijira.service;

import com.ukg.intellijira.model.StoryRequest;
import com.ukg.intellijira.model.StoryResponse;

public interface IntelliJiraService {
    StoryResponse createStories(StoryRequest chatRequest);
}
