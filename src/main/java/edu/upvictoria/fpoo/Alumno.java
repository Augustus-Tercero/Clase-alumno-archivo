package edu.upvictoria.fpoo;

import java.util.Scanner;

public class Alumno {
    private String name;
    private String enrollment;
    private Integer[] grades;
    private int unitCount;

    public Alumno() {
        this.name = "";
        this.enrollment = "";
        this.grades = new Integer[]{};
        this.unitCount = 0;
    }

    public Alumno(String name) {
        this();
        this.name = name;
    }

    public Alumno(String name, String enrollment) {
        this(name);
        this.enrollment = enrollment;
    }

    public void setGrade(int unitCount, Integer[] grades) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < unitCount; i++) {
            System.out.println("Ingresa la calificación de la unidad " + i);
            grades[i] = scanner.nextInt();
        }
        scanner.close();
        setGrades(grades);
    }

    public Alumno(String name, String enrollment, int unitCount) {
        this(name,enrollment);
        this.unitCount = unitCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
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
}
