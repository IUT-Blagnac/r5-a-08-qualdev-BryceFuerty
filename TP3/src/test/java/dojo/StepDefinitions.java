package dojo;

import io.cucumber.java.en.*;

import java.io.File;

import org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    
    FileSearch filePDF = new FileSearch();
    

    @Given("The file is : {string}")
    public void givenAFile(String fichier) {
        filePDF.setDirFile(fichier);
    }

    @When("The subject is {string}")
    public void allStepDefinitionsAreImplemented(String sujet) {
        filePDF.setSubjectFile(sujet);
    }

    @Then("The file should cite the subject")
    public void theFileSouldCiteTheSubject() {
        filePDF.verifyContent();
    }

}
