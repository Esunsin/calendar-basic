package com.sparta.calendar.service;

import com.sparta.calendar.entity.Schedule;
import com.sparta.calendar.repository.MemoryScheduleRepository;
import com.sparta.calendar.repository.ScheduleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest {

    private ScheduleService scheduleService = new ScheduleService(new MemoryScheduleRepository());

    @Test
    void registerSchedule() {
        Schedule schedule = new Schedule("오늘의 일정","스프링공부하고 쉬고 밤샘각이네","정진찬","1234");
        scheduleService.registerSchedule(schedule);
        Schedule findSchedule = scheduleService.findSchedule(schedule.getScheduleId());
        Assertions.assertThat(schedule).isEqualTo(findSchedule);
    }

    @Test
    void findAllSchedule() {
        Schedule schedule1 = new Schedule("오늘의 일정1","스프링공부하고 쉬고 밤샘각이네ㅠ","정진찬1","1234");
        Schedule schedule2 = new Schedule("오늘의 일정2","스프링공부하고 쉬고 밤샘각이네ㅠㅠ","정진찬2","12345");
        Schedule schedule3 = new Schedule("오늘의 일정3","스프링공부하고 쉬고 밤샘각이네ㅠㅠㅠ","정진찬3","123456");
        scheduleService.registerSchedule(schedule1);
        scheduleService.registerSchedule(schedule2);
        scheduleService.registerSchedule(schedule3);
        Assertions.assertThat(scheduleService.findAllSchedule().size()).isEqualTo(3);
    }
    @Test
    void updateScheduleContent() {
        Schedule schedule1 = new Schedule("오늘의 일정1","스프링공부하고 쉬고 밤샘각이네ㅠ","정진찬1","1234");
        scheduleService.registerSchedule(schedule1);
        System.out.println(schedule1.getContent());
        scheduleService.updateScheduleContent(schedule1.getScheduleId(), "그래도 재미있네");
        System.out.println(schedule1.getContent());
    }
    @Test
    void deleteSchedule() {
        Schedule schedule1 = new Schedule("오늘의 일정1","스프링공부하고 쉬고 밤샘각이네ㅠ","정진찬1","1234");
        Schedule schedule2 = new Schedule("오늘의 일정2","스프링공부하고 쉬고 밤샘각이네ㅠㅠ","정진찬2","12345");
        Schedule schedule3 = new Schedule("오늘의 일정3","스프링공부하고 쉬고 밤샘각이네ㅠㅠㅠ","정진찬3","123456");
        scheduleService.registerSchedule(schedule1);
        scheduleService.registerSchedule(schedule2);
        scheduleService.registerSchedule(schedule3);
        scheduleService.deleteSchedule(schedule1.getScheduleId());
        Assertions.assertThat(scheduleService.findAllSchedule().size()).isEqualTo(2);

    }

    @Test
    void isContainById() {
        Schedule schedule1 = new Schedule("오늘의 일정1","스프링공부하고 쉬고 밤샘각이네ㅠ","정진찬1","1234");
        scheduleService.registerSchedule(schedule1);
        System.out.println(schedule1.getScheduleId());
        boolean containById = scheduleService.isContainById(1L);
        Assertions.assertThat(containById).isEqualTo(true);
        boolean falseContainById = scheduleService.isContainById(2L);
        Assertions.assertThat(falseContainById).isEqualTo(false);
    }
}