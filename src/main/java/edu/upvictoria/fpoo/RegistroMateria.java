package edu.upvictoria.fpoo;

import java.util.ArrayList;
import java.util.HashMap;
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
            var student = new Alumno(auxArrContent.get(0),auxArrContent.get(1),this.unitCount);
            var grades = new Integer[this.unitCount];
            for (int i = 2; i < auxArrContent.size(); i++) {
                grades[i-2] = Integer.parseInt(auxArrContent.get(i));
            }
            student.setGrades(grades);
            this.gradesList.put(student.getId(),student);
        }
    }

    public String toString() {
        return "Registro{" +
                "gradesList=" + gradesList +
                ", subjectName='" + subjectName + '\'' +
                ", unitCount=" + unitCount +
                '}';
    }
}
