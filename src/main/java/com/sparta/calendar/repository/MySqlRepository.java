package com.sparta.calendar.repository;

import com.sparta.calendar.entity.Schedule;

import java.util.List;

public class MySqlRepository implements ScheduleRepository{
    @Override
    public void save(Schedule schedule) {

    }

    @Override
    public Schedule findById(Long Id) {
        return null;
    }

    @Override
    public Schedule delete(Long id) {
        return null;
    }

    @Override
    public List<Schedule> findAll() {
        return null;
    }
}
