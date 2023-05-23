package com.example.OrgJavaRest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name = "ADULT_TRAIN_JAVA")
@JsonPropertyOrder({"recordId", "age", "workclass", "fnlwgt", "education", "age", "educationNum", "maritalStatus", "occupation", "relationship", "race", "sex", "capitalGain", "capitalLoss", "hoursPerWeek", "country", "target", "partDate"})
public class AdultTrainJava implements Serializable {
    @Id
    @Column(name = "recordId", nullable = false)
    @JsonProperty("recordId")
    private Long recordId;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("workclass")
    private String workclass;
    @JsonProperty("fnlwgt")
    private Integer fnlwgt;
    @JsonProperty("education")
    private String education;
    @JsonProperty("educationNum")
    private Integer educationNum;
    @JsonProperty("maritalStatus")
    private String maritalStatus;
    @JsonProperty("occupation")
    private String occupation;
    @JsonProperty("relationship")
    private String relationship;
    @JsonProperty("race")
    private String race;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("capitalGain")
    private Integer capitalGain;
    @JsonProperty("capitalLoss")
    private Integer capitalLoss;
    @JsonProperty("hoursPerWeek")
    private Integer hoursPerWeek;
    @JsonProperty("country")
    private String country;
    @JsonProperty("proxy")
    private String proxy;
    @JsonProperty("target")
    private Integer target;
    @JsonProperty("partDate")
    private String partDate;


    public AdultTrainJava(){

    }

    public AdultTrainJava(String data){
        String[] argArray = data.split(",");
        this.recordId = Long.valueOf(Integer.parseInt(argArray[0]));
        this.age = Integer.parseInt(argArray[1]);
        this.workclass = argArray[2];
        this.fnlwgt = Integer.parseInt(argArray[3]);
        this.education = argArray[4];
        this.educationNum = Integer.parseInt(argArray[5]);
        this.maritalStatus = argArray[6];
        this.occupation = argArray[7];
        this.relationship = argArray[8];
        this.race = argArray[9];
        this.sex = argArray[10];
        this.capitalGain = Integer.parseInt(argArray[11]);
        this.capitalLoss = Integer.parseInt(argArray[12]);
        this.hoursPerWeek = Integer.parseInt(argArray[13]);
        this.country = argArray[14];
        this.proxy = argArray[15];
        this.target = Integer.parseInt(argArray[16]);
        this.partDate = argArray[17];
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkclass() {
        return workclass;
    }

    public void setWorkclass(String workclass) {
        this.workclass = workclass;
    }

    public Integer getFnlwgt() {
        return fnlwgt;
    }

    public void setFnlwgt(Integer fnlwgt) {
        this.fnlwgt = fnlwgt;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getEducationNum() {
        return educationNum;
    }

    public void setEducationNum(Integer educationNum) {
        this.educationNum = educationNum;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCapitalGain() {
        return capitalGain;
    }

    public void setCapitalGain(Integer capitalGain) {
        this.capitalGain = capitalGain;
    }

    public Integer getCapitalLoss() {
        return capitalLoss;
    }

    public void setCapitalLoss(Integer capitalLoss) {
        this.capitalLoss = capitalLoss;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public String getPartDate() {
        return partDate;
    }

    public void setPartDate(String partDate) {
        this.partDate = partDate;
    }

    @Override
    public String toString() {
        return "AdultTrainJava{" +
                "recordId=" + recordId +
                ", age=" + age +
                ", workclass='" + workclass + '\'' +
                ", fnlwgt='" + fnlwgt + '\'' +
                ", education='" + education + '\'' +
                ", educationNum=" + educationNum +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", occupation='" + occupation + '\'' +
                ", relationship='" + relationship + '\'' +
                ", race='" + race + '\'' +
                ", sex='" + sex + '\'' +
                ", capitalGain=" + capitalGain +
                ", capitalLoss=" + capitalLoss +
                ", hoursPerWeek=" + hoursPerWeek +
                ", country='" + country + '\'' +
                ", proxy='" + proxy + '\'' +
                ", target=" + target +
                ", partDate='" + partDate + '\'' +
                '}';
    }

    // Method
    // Creating toString
    public String toMyString()
    {
        // Returning attributes of organisation
        return "\"AdultTrainJava [recordId=" +recordId
                + ", age="+ age
                + ", workclass=" + workclass
                + ", fnlwgt=" + fnlwgt
                + ", education=" + education
                + ", educationNum=" + educationNum
                + ", maritalStatus=" + maritalStatus
                + ", occupation=" + occupation
                + ", relationship=" + relationship
                + ", race=" + race
                + ", race=" + sex
                + ", capitalGain=" + capitalGain
                + ", capitalLoss=" + capitalLoss
                + ", hoursPerWeek=" + hoursPerWeek
                + ", country=" + country
                + ", proxy=" + proxy
                + ", target=" + target
                + ", partDate=" + partDate + "]";
    }

}
