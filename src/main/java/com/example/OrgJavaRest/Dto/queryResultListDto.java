package com.example.OrgJavaRest.Dto;

import lombok.Data;

import java.util.List;
@Data
public class queryResultListDto {
    private List<queryResultDto> queryList;
}
