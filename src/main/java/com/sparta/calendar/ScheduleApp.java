package com.sparta.calendar;

import com.sparta.calendar.entity.Schedule;
import com.sparta.calendar.repository.MemoryScheduleRepository;
import com.sparta.calendar.repository.ScheduleRepository;

import java.util.Date;

public class ScheduleApp {
    public static void main(String[] args) {
        Schedule schedule = new Schedule( "aaa", "asdasdasd", "jinchan", "0000");
        ScheduleRepository scheduleRepository = new MemoryScheduleRepository();
        scheduleRepository.save(schedule);
        Schedule findSchedule = scheduleRepository.findById(1L);
        System.out.println(findSchedule.getScheduleId() +
                " " + findSchedule.getTitle() +
                " " + findSchedule.getContent() +
                " " + findSchedule.getWriter() +
                " " + findSchedule.getDate());
    }
}
