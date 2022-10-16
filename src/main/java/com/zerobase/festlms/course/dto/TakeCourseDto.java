package com.zerobase.festlms.course.dto;

import com.zerobase.festlms.course.entity.TakeCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TakeCourseDto {
    long id;

    long courseId;
    String userId;

    long payPrice;
    String status;

    LocalDateTime regDt;

    String userName;
    String phone;
    String subject;

    long totalCount;
    long seq;

    public String getRegDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }

    public static TakeCourseDto of(TakeCourse takeCourse) {
        return TakeCourseDto.builder()
                .id(takeCourse.getId())
                .courseId(takeCourse.getCourseId())
                .userId(takeCourse.getUserId())
                .payPrice(takeCourse.getPayPrice())
                .status(takeCourse.getStatus())
                .regDt(takeCourse.getRegDt())
                .build();
    }
}
