package it.polito.tdp.numero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class numeroController {
	
	
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
    boolean ingame=false;
    private int segreto=0;
    private int tentativiFatti=0;
    final int tentativiMassimi=6;
    @FXML
    
    void handleNuovaPartita(ActionEvent event) {
    	//crea una nuova partita
    	//grafica
     this.rimasti.setText(Integer.toString(this.tentativiMassimi));
    this.boxControlloPartita.setDisable(true);
    	this.boxControlloTentativo.setDisable(false);
    	this.txtmessaggi.clear();
    	this.tentativo.clear();
    	ingame=true;
    	this.tentativiFatti=0;
    	//logica
    	//crea numero
    	this.segreto= (int)((Math.random()*100)+1);
    	
    	
    

    }
    //funzione che termina la partita
 public void fine() {
	 ingame= false;
	 this.boxControlloPartita.setDisable(false);
	 this.boxControlloTentativo.setDisable(true);
	 return;
	
 
 }
 
    @FXML
    void handleProva(ActionEvent event) {
     if (this.tentativo.getLength()==0) {scrivi("inserisci un numero\n");return;}
     try { int prova = Integer.parseInt(this.tentativo.getText());
     this.tentativiFatti++;
     this.rimasti.setText(Integer.toString(this.tentativiMassimi-this.tentativiFatti)) ;
     
   
     if (ingame==true) {
    	 if (prova==this.segreto) {scrivi("complimenti, hai indovinato\n");
     	fine(); return;}
    	 else if (this.tentativiFatti==this.tentativiMassimi) {scrivi("HAI PERSO, il numero era: "+this.segreto);fine();return;}
    		 
    	 if (prova<=this.segreto) {scrivi("troppo piccolo\n");}
    	 if (prova>=this.segreto) {scrivi("troppo grande\n");return;}
     	}
    }catch ( NumberFormatException badData )
    {scrivi("non hai inserito un numero valido\n");
    }
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
}
