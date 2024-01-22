package com.sparta.calendar.dto;


import lombok.Getter;

@Getter
public class ResponseDto {
    private Long scheduleId;
    private String title;
    private String content;
    private String writer;
    private String date;

    public ResponseDto(Long scheduleId, String title, String content, String writer, String date) {
        this.scheduleId = scheduleId;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }
}
