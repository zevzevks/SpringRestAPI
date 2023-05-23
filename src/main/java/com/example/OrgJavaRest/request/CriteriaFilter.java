package com.example.OrgJavaRest.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CriteriaFilter {
    private String columnName;
    private String columnValueInt;
    private String columnValueStr;
}
