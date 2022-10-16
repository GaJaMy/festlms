package com.zerobase.festlms.course.mapper;

import com.zerobase.festlms.course.dto.CourseDto;
import com.zerobase.festlms.course.model.CourseParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    long selectListCount(CourseParam parameter);
    List<CourseDto> selectList(CourseParam parameter);
}
