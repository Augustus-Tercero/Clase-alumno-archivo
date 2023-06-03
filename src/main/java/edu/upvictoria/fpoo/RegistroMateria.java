package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RegistroMateria {
    private HashMap<String,Alumno> gradesList;
    private String subjectName;
    private Integer unitCount;

    public RegistroMateria(String subjectName, Integer unitCount) {
        this.subjectName = subjectName;
        this.unitCount = unitCount;
        this.gradesList = new HashMap<String,Alumno>();
    }

    public void loadFileGrades(String file_name, String regex_separator, boolean omit_header) {
        var archivo = new Archivo(file_name);
        var tempArr = archivo.getFileContent();
        if (omit_header)
            tempArr.remove(0);
        for (var row : tempArr) {
            var cols = new StringTokenizer(row,regex_separator);
            var auxArrContent = new ArrayList<String>();
            while (cols.hasMoreTokens()) {
                auxArrContent.add(cols.nextToken());
            }
            var student = new Alumno(auxArrContent.get(1),auxArrContent.get(0),this.unitCount);
            var grades = new Integer[this.unitCount];
            for (int i = 2; i < auxArrContent.size(); i++) {
                grades[i-2] = Integer.parseInt(auxArrContent.get(i));
            }
            student.setGrades(grades);
            this.gradesList.put(student.getId(),student);
        }
    }

    public Float getGPA(String id) {
        Float gpa = 0f;
        for (var entry : this.gradesList.entrySet()) {
            if (entry.getKey() == id) {
                gpa = entry.getValue().calculateGPA();
            }
        }
        return gpa;
    }

    public String[] getStudentData(String id) {
        var data = new String[3];
        for (var entry : this.gradesList.entrySet()) {
            if (entry.getKey().equals(id)) {
                data[0] = entry.getValue().getId();
                data[1] = entry.getValue().getName();
                var auxArrGrades = entry.getValue().getGrades();
                data[2] = auxArrGrades[0].toString();
                // data[2] += auxArrGrades[0]; // se concatena la palabra "null" wtfffff
                for (int i = 1; i < auxArrGrades.length; i++) {
                    data[2] += "," + auxArrGrades[i];
                }
            }
        }
        return data;
    }

    public String toString() {
        return "Registro{" +
                "gradesList=" + gradesList +
                ", subjectName='" + subjectName + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }
}
