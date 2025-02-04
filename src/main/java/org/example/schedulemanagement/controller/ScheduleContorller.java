package org.example.schedulemanagement.controller;


import org.example.schedulemanagement.dto.ScheduleRequestDto;
import org.example.schedulemanagement.dto.ScheduleResponseDto;
import org.example.schedulemanagement.entity.Schedule;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules") // prefix

public class ScheduleContorller {
    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;


        Schedule schedule = new Schedule(scheduleId, requestDto.getWriter(), requestDto.getContents(), requestDto.getPassword(), requestDto.getDate());

        scheduleList.put(scheduleId, schedule);



        return new ScheduleResponseDto(schedule);
    }

    @GetMapping("/{date}")
    public ScheduleResponseDto findScheduleByDate(@PathVariable LocalDateTime date) {

        Schedule schedule = scheduleList.get(date);

        return new ScheduleResponseDto(schedule);
    }

    @PutMapping("/{date}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable String date,
            @RequestBody ScheduleRequestDto requestDto
    ) {

        Schedule schedule = scheduleList.get(date);

        schedule.update(requestDto);


        return new ScheduleResponseDto(schedule);
    }
    @DeleteMapping("/{date}")
    public void deleteSchedule(
            @PathVariable Long date
    ) {
        scheduleList.remove(date);
    }
    @DeleteMapping("/{modifydate}")
    public void deleteSchedule(
            @PathVariable LocalDateTime modifydate
    ) {
        scheduleList.remove(modifydate);
    }
}
