package com.sparta.calendar.repository;

import com.sparta.calendar.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ScheduleRepository {
    void save(Schedule schedule);

    Schedule findById(Long Id);

    Schedule delete(Long id);

    List<Schedule> findAll();

}
