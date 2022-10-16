package com.zerobase.festlms.course.model;

import lombok.Data;

@Data
public class CourseInput {
    long Id;
    long categoryId;
    String subject;
    String keyword;
    String summary;
    String contents;
    long price;
    long salePrice;
    String saleEndDtText;

    String idList;

    String filename;
    String urlFilename;
}
