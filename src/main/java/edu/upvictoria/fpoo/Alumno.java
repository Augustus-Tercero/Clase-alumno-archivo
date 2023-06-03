package edu.upvictoria.fpoo;

import java.util.Arrays;

public class Alumno {
    private String name;
    private String id;
    private Integer[] grades;
    private int unitCount;

    public Alumno(String name, String enrollment, int unitCount) {
        this.name = name;
        this.id = enrollment;
        this.unitCount = unitCount;
        this.grades = new Integer[]{};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Integer[] getGrades() {
        return grades;
    }

    public void setGrades(Integer[] scores) {
        this.grades = scores;
    }

    public int getUnitCount() {
        return unitCount;
    }

    public void setUnitCount(int unitCount) {
        this.unitCount = unitCount;
    }
    public float calculateGPA() {
        Integer gpa = 0;
        for (var unit : this.grades) {
            gpa += unit;
        }
        return (float) gpa / this.unitCount;
    }

    public void setGrade(int unit, Integer grade) {
        this.grades[unit] = grade;
    }

    @Override // intelliji
    public String toString() {
        return "Alumno{" +
                "name='" + name + '\'' +
                ", enrollment='" + id + '\'' +
                ", grades=" + Arrays.toString(grades) +
                ", unitCount=" + unitCount +
                '}';
    }
}
