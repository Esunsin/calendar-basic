package com.sparta.calendar.controller;

import com.sparta.calendar.dto.RequestDto;
import com.sparta.calendar.dto.ResponseDto;
import com.sparta.calendar.entity.Schedule;
import com.sparta.calendar.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    //ocp, dip 깨짐.. -> autoAppConfig로 바꿔서 외부에서 의존관계 주입해야함.
    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseDto createSchedule(@RequestBody RequestDto requestDto) {
        //requestDto -> entity
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getContent(), requestDto.getWriter(), requestDto.getPassword());
        //DB저장
        scheduleService.registerSchedule(schedule);
        //entity -> responseDto
        ResponseDto responseDto = new ResponseDto(schedule.getScheduleId(), schedule.getTitle(), schedule.getContent(), schedule.getWriter(), schedule.getDate());
        return responseDto;
    }

    @GetMapping
    public List<ResponseDto> getSchedules() {
        List<ResponseDto> responseDtos = new ArrayList<>();
        List<Schedule> schedules = scheduleService.findAllSchedule();
        for (Schedule schedule : schedules) {
            responseDtos.add(new ResponseDto(schedule.getScheduleId(), schedule.getTitle(), schedule.getContent(), schedule.getWriter(), schedule.getDate()));
        }
        return responseDtos;
    }

    //content만 바꿈
    @PutMapping("/{id}")
    public Long updateSchedule(@PathVariable Long id, @RequestBody RequestDto requestDto) {
        if (scheduleService.isContainById(id)) {
            //비밀번호
            if (requestDto.getPassword() == scheduleService.findSchedule(id).getPassword()) {
                Schedule schedule = scheduleService.updateScheduleContent(id, requestDto.getContent());
                return schedule.getScheduleId();
            } else {
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            }
        } else {
            throw new IllegalArgumentException("없는 스케줄 입니다.");
        }
    }

    @DeleteMapping("/{id}")
    public Long deleteSchedule(@PathVariable Long id) {
        if (scheduleService.isContainById(id)) {
            scheduleService.deleteSchedule(id);
            return id;
        }
        else {
            throw new IllegalArgumentException("없는 스케줄 입니다.");
        }
    }
}
