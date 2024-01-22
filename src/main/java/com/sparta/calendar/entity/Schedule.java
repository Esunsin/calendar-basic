package com.sparta.calendar.entity;

import com.sparta.calendar.dto.RequestDto;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class Schedule {

    private static Long idx = 1L;

    private Long scheduleId;
    private String title;
    private String content;
    private String writer;
    private String date;
    private String password;


    public Schedule(String title, String content, String writer, String password) {
        this.scheduleId = idx++;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = new SimpleDateFormat("yyy-MM-dd hh:mm:ss").format(new Date());;
        this.password = password;
    }


    public void updateContent(String content){
        this.content = content;
    }
}
