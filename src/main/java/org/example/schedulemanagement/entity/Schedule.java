package org.example.schedulemanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.schedulemanagement.dto.ScheduleRequestDto;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {
    private Long id;
    private String writer;
    private String contents;
    private String password;
    private LocalDateTime date;
    private LocalDateTime modifydate;

    public void update(ScheduleRequestDto requestDto) {
        this.writer = requestDto.getWriter();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.date = requestDto.getDate();
        this.modifydate = requestDto.getModifydate();
    }
}
