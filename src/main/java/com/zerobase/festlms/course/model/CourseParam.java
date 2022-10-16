package com.zerobase.festlms.course.model;

import com.zerobase.festlms.admin.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {
    long id;
    long categoryId;

}
