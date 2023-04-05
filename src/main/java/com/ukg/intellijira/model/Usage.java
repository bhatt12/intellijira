package com.ukg.intellijira.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Usage implements Serializable {

    private String prompt_tokens;

    private String completion_tokens;

    private String total_tokens;
}
