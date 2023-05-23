package com.example.OrgJavaRest.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class queryResultDto {
    private Integer recordId;
    private Integer age;
    private String workclass;
    private Integer fnlwgt;
    private String education;
    private Integer educationNum;
    private String maritalStatus;
    private String occupation;
    private String relationship;
    private String race;
    private String sex;
    private Integer capitalGain;
    private Integer capitalLoss;
    private Integer hoursPerWeek;
    private String country;
    private String proxy;
    private Integer target;
    private String partDate;

    public queryResultDto(int recordId) {
        this.recordId = recordId;
    }


}
