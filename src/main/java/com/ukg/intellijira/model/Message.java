package com.ukg.intellijira.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

    private String content;

    private String role;

}
