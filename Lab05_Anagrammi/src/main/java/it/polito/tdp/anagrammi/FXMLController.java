package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTesto;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAreaC;

    @FXML
    private TextArea txtAreaE;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola;

    	txtAreaC.clear();
    	txtAreaE.clear();

    	parola = txtTesto.getText();

    	if(parola.length()<2) {
    		txtAreaC.appendText("Parola inserita troppo corta");
    		txtAreaE.appendText("Parola inserita troppo corta");
    		return;
    	}
    	if(parola.length()>8) {
    		txtAreaC.appendText("Parola inserita troppo lunga");
    		txtAreaE.appendText("Parola inserita troppo lunga");
    		return;
    	}

    	List<String> anagrammi = this.model.anagrammi(parola);

    	for(String anagramma : anagrammi){
    		if(this.model.isCorrect(anagramma))
    			txtAreaC.appendText(anagramma + "\n");
    		else
    			txtAreaE.appendText(anagramma + "\n");
    	}

    }


    

    @FXML
    void doCancella(ActionEvent event) {
    	txtTesto.clear();
    	txtAreaC.clear();
    	txtAreaE.clear();
    }

    @FXML
    void initialize() {
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaC != null : "fx:id=\"txtAreaC\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAreaE != null : "fx:id=\"txtAreaE\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}
