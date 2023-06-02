package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class Archivo {
    private ArrayList<String> fileContent;
    private File file;

    public Archivo(String path) {
        this.file = new File(path);
        System.out.println(this.file.exists() ? "Cargando archivo..." : "Archivo no encontrado");
    }

    public void showFileContent() {
        var temp = getFileContent();
        System.out.println(temp);
    }

    public Archivo(File path) {
        this.file = path;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public ArrayList<String> getFileContent() {
        ArrayList<String> fileContent = new ArrayList<String>();
        String line;
        try {
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                fileContent.add(line);
            }
            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    public void setFileContent(ArrayList<String> fileContent) {
        this.fileContent = fileContent;
    }
}
