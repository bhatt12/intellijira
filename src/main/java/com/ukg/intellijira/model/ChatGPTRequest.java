package com.ukg.intellijira.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class ChatGPTRequest {

    private String model;

    private List<Message> messages;
}
