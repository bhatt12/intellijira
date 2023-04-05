package com.ukg.intellijira.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Choice implements Serializable {

    private Integer index;
    private Message message;
    private String finish_reason;
}
