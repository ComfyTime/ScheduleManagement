package org.example.schedulemanagement.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String writer;
    private String contents;
    private String password;
    private String date;
    private String modifydate;
}
