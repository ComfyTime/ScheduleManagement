package org.example.schedulemanagement.dto;

import lombok.Getter;
import org.example.schedulemanagement.entity.Schedule;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String writer;
    private String contents;
    private LocalDateTime date;
    private LocalDateTime modifydate;

    //생성자
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.writer = schedule.getWriter();
        this.contents = schedule.getContents();
        this.date = schedule.getDate();
        this.modifydate = schedule.getModifydate();
    }
}
