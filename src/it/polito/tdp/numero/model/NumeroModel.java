package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class NumeroModel{
	
	 private boolean inGame=false;
	 private final int NMAX=100;
	 private final int Tmax=8;
	 private int segreto=0;
	 private int tentativiFatti=0;
	
	
	 /**
	  * Avvia una nuova partita
	  */
	 public void newGame() {
		 inGame=true;
		 this.tentativiFatti=0;
		 this.segreto= (int)((Math.random()*100)+1);
		
	}
	 public void termina() {
		 inGame=false;
	 }
	 
//costruttore
	public NumeroModel(){
		inGame=false;
	}
	
	public int tentativo(int t) {
		if (!inGame) {throw new IllegalStateException("la partita è terminata");}
		if (!tentativoValido(t)) {throw new InvalidParameterException (String.format("il numero deve essere compreso tra %d e %d",1,NMAX));}
		this.tentativiFatti++;
		if (this.tentativiFatti==this.Tmax) {inGame=false;}
		if (t==this.segreto) {this.inGame=false; return 0;}
		if (t>this.segreto) {return 1;}
		return -1;
		
		}
	
	
	
	
	public boolean tentativoValido(int t) {
		if (t<1|t>NMAX) {return false;}
		else return true;
		
	}
	public boolean isInGame() {
		return inGame;
	}
	public int getTentativiFatti() {
		return tentativiFatti;
	}
	public int getTmax() {
		return Tmax;
	}
	
		
	
	
	
	
}
