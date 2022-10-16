package com.zerobase.festlms.course.service;

import com.zerobase.festlms.course.dto.CourseDto;
import com.zerobase.festlms.course.entity.TakeCourse;
import com.zerobase.festlms.course.model.CourseInput;
import com.zerobase.festlms.course.model.CourseParam;
import com.zerobase.festlms.course.model.ServiceResult;

import java.util.List;

public interface CourseService {

    boolean add(CourseInput parameter);

    List<CourseDto> list(CourseParam parameter);

    CourseDto getById(long id);

    boolean set(CourseInput parameter);

    boolean del(String idList);

    List<CourseDto> frontList(CourseParam parameter);

    CourseDto frontDetail(long id);

    ServiceResult req(TakeCourse parameter);

    List<CourseDto> listAll();
}
