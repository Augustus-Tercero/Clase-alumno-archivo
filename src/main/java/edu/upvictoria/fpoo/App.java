package edu.upvictoria.fpoo;

import edu.upvictoria.fpoo.Archivo;

public class App {
    public static void main( String[] args ) {
        var file = new Archivo("./test.txt");
        file.showFileContent();
        System.out.println("");
    }
}
