package com.sparta.calendar.dto;

import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class RequestDto {
    private String title;
    private String content;
    private String writer;
    private String password;
}
