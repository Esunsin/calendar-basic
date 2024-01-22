package com.sparta.calendar.service;

import com.sparta.calendar.entity.Schedule;
import com.sparta.calendar.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void registerSchedule(Schedule schedule){
        scheduleRepository.save(schedule);
    }

    public Schedule findSchedule(Long id){
        return scheduleRepository.findById(id);
    }

    public List<Schedule> findAllSchedule(){
        return scheduleRepository.findAll();
    }
    public Schedule updateScheduleContent(Long id,String inputContent){
        Schedule schedule = scheduleRepository.findById(id);
        schedule.updateContent(inputContent);
        //덮어쓰기..ㅠ
        scheduleRepository.save(schedule);
        return schedule;
    }

    public Long deleteSchedule(Long id) {
        return scheduleRepository.delete(id).getScheduleId();
    }

    public boolean isContainById(Long inputId){
        List<Schedule> schedules = scheduleRepository.findAll();
        for (Schedule schedule : schedules) {
            if(schedule.getScheduleId() == inputId) return true;
        }
        return false;
    }

}
