package com.zerobase.festlms.course.service;

import com.zerobase.festlms.course.dto.TakeCourseDto;
import com.zerobase.festlms.course.model.ServiceResult;
import com.zerobase.festlms.course.model.TakeCourseParam;

import java.util.List;

public interface TakeCourseService {
    List<TakeCourseDto> list(TakeCourseParam parameter);
    ServiceResult updateStatus(long id, String status);

    List<TakeCourseDto> myCourse(String userId);
    TakeCourseDto detail(long id);

    ServiceResult cancel(long id);
}
