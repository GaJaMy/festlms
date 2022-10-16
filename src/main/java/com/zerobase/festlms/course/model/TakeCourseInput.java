package com.zerobase.festlms.course.model;

import lombok.Data;

@Data
public class TakeCourseInput {
    long courseId;
    String userId;

    long takeCourseId;
}
