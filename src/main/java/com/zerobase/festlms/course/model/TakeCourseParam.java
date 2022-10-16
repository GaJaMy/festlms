package com.zerobase.festlms.course.model;

import com.zerobase.festlms.admin.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam {
    long id;
    String status;

    String userId;
    long searchCourseId;
}
