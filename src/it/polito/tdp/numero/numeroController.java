package it.polito.tdp.numero;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.numero.model.NumeroModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class numeroController {
	NumeroModel model;
		
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox boxControlloPartita;

    @FXML
    private TextField rimasti;

    @FXML
    private HBox boxControlloTentativo;

    @FXML
    private TextField tentativo;

    @FXML
    private TextArea txtmessaggi;
   
    @FXML
    
    void handleNuovaPartita(ActionEvent event) {
    
        this.boxControlloPartita.setDisable(true);
    	this.boxControlloTentativo.setDisable(false);
    	this.txtmessaggi.clear();
    	this.rimasti.setText(Integer.toString(model.getTmax()));
    	model.newGame(); 	
    	    	
    }
    
    //funzione che termina la partita
    public void fine() {
	 this.boxControlloPartita.setDisable(false);
	 this.boxControlloTentativo.setDisable(true);
	 model.termina();
	 
 }
 
    @FXML
    void handleProva(ActionEvent event) {
    	String ts= this.tentativo.getText();
    	int tent;
    	try { tent = Integer.parseInt(ts);    
    		}catch ( NumberFormatException badData )
          	{scrivi("non hai inserito un numero valido\n");return;
          	}
    if (!model.tentativoValido(tent)) {this.txtmessaggi.appendText("range non valido");
    return;
    }
    
    int risultato= model.tentativo(tent);
    if (risultato==0) {scrivi("hai indovinato\n");this.fine();}
    else if (risultato==1) {scrivi("troppo grande\n");}
    	else if (risultato==-1) {scrivi("troppo piccolo\n");}
    this.rimasti.setText(Integer.toString(model.getTmax()-model.getTentativiFatti()));
   if ((model.getTmax()-model.getTentativiFatti())==0) {this.fine() ;}
    
    }
    
    public void scrivi(String a) {
    	this.txtmessaggi.appendText(a);
    }
    

    @FXML
    void handleProvaTentativo(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert boxControlloPartita != null : "fx:id=\"boxControlloPartita\" was not injected: check your FXML file 'numero.fxml'.";
        assert rimasti != null : "fx:id=\"rimasti\" was not injected: check your FXML file 'numero.fxml'.";
        assert boxControlloTentativo != null : "fx:id=\"boxControlloTentativo\" was not injected: check your FXML file 'numero.fxml'.";
        assert tentativo != null : "fx:id=\"tentativo\" was not injected: check your FXML file 'numero.fxml'.";
        assert txtmessaggi != null : "fx:id=\"txtmessaggi\" was not injected: check your FXML file 'numero.fxml'.";

    }

    public void setModel(NumeroModel model) {
		this.model = model;
	}
}
