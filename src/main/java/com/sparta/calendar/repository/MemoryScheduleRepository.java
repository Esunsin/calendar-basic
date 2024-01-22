package com.sparta.calendar.repository;

import com.sparta.calendar.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryScheduleRepository implements ScheduleRepository{

    //동시성 고려x(멀티쓰레드 환경생각x)
    private final Map<Long, Schedule> store = new HashMap<>();

    @Override
    public void save(Schedule schedule) {

        store.put(schedule.getScheduleId(), schedule);
    }

    @Override
    public Schedule findById(Long id) {
        return store.get(id);
    }

    @Override
    public Schedule delete(Long id) {
        return store.remove(id);
    }

    @Override
    public List<Schedule> findAll() {
        List<Schedule> schedules = new ArrayList<>();
        for (Long id : store.keySet()) {
            schedules.add(store.get(id));
        }
        return schedules;
    }

}
