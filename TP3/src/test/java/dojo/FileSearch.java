package dojo;


import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Assertions;

public class FileSearch {

    private Boolean textIsPresent;
    private String subject;
    private String fileDir;

    public void setStateFile(Boolean state){
        this.textIsPresent = state;
    }
    
    public Boolean getStateFile(){
        return this.textIsPresent;
    }

    public void setSubjectFile(String subject){
        this.subject = subject;
    }
    
    public String getSubjectFile(){
        return this.subject;
    }

    public void setDirFile(String file){
        this.fileDir = "/" + file;
    }
    
    public String getDirFile(){
        return this.fileDir;
    }
    public Boolean verifyContent() {
        this.textIsPresent = false;
        String dir = "/src/test/java/dojo/";
        Path currentDirectoryPath = FileSystems.getDefault().getPath("");
        String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString() + dir;
        
        try {
            File file = new File(currentDirectoryName + this.fileDir);

            if (!file.exists()) {
                Assertions.fail("Le fichier n'existe pas : " + file.getAbsolutePath());
            }

            PDDocument doc = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            String text = pdfStripper.getText(doc);

            if (text.contains(this.subject)) {
                this.textIsPresent = true;
            } else {
                this.textIsPresent = false;
            }


            Assertions.assertTrue(this.textIsPresent);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.textIsPresent;
    }


}
