package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Archivo;

public class App {
    public static void main( String[] args ) {
        var resources = "./src/main/resources/";
        var registro = new RegistroMateria("Sistemas inteligentes",4);
        registro.loadFileGrades((resources + "sistemas_inteligentes.csv"), "\t", true);
        var test = registro.getStudentData("1930773");
        System.out.println();
    }
}