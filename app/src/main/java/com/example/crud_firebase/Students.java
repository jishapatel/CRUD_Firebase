package com.example.crud_firebase;

public class Students {
    String name;
    String course;
    String sem;
    String ins;

    public Students(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public Students(String name, String course, String sem, String ins) {
        this.name = name;
        this.course = course;
        this.sem = sem;
        this.ins = ins;
    }
}