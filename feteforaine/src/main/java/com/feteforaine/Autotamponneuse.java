package com.feteforaine;

import java.util.Random;

public class Autotamponneuse {
	private double posX, posY;
	private String conducteur;
	private boolean power, blink, destroyed;
	private final long id;
	private static long idCount = 1;
	private final static double DISTANCE_MINIMALE = 10;
	private final static double MIN_SIZE = 0;
	private final static double MAX_SIZE = 100;

	public double calculeDistance(Autotamponneuse autreAuto){
		double x = this.posX - autreAuto.posX;
		double y = this.posY - autreAuto.posY;

		double result = Math.sqrt((x*x) + (y*y));
		return result;
	}

	public boolean equals(Object autreObjet) {
		if(autreObjet instanceof Autotamponneuse){
			Autotamponneuse autreAuto = (Autotamponneuse)autreObjet;
			if (this.estClignotante() == autreAuto.estClignotante())
				return true;
			else
				return false;
		}
		return false;
	}

	static double calculeDistance(Autotamponneuse auto1, Autotamponneuse auto2){
		double x = auto1.posX - auto2.posX;
		double y = auto1.posY - auto2.posY;

		double result = Math.sqrt((x*x) + (y*y));
		return result;
	}

	public boolean collision (Autotamponneuse autreAuto){
		return calculeDistance(autreAuto) < DISTANCE_MINIMALE;
	}

	static boolean collision (Autotamponneuse auto1, Autotamponneuse auto2){
		return calculeDistance(auto1, auto2) < DISTANCE_MINIMALE;
	}

	public Autotamponneuse(double pPosX, double PposY){
		posX = pPosX;
		posY = PposY;
		conducteur = "";
		power = false;
		blink = false;
		id = idCount++;
	}
	
	public Autotamponneuse(){
		posX = 0;
		posY = 0;
		conducteur = "";
		power = false;
		blink = false;
		id = idCount++;
	}
	
	public boolean estOccupee(){
		return conducteur!="";
	}
	
	public String getNomOccupant(){
		return conducteur;
	}
	
	public boolean estAllumee(){
		return power && estOccupee();
	}
	
	public boolean estClignotante(){
		return blink && estAllumee();
	}

	public long getId() {
		return id;
	}

	public void removeId(){
		idCount--;
	}

	public void moveRandom(){
		double rand = Math.random();
		int direction = (int)(rand*4);
		if(direction == 0){
			if(posX > MIN_SIZE)
				posX--;
			else
				posX++;
		}
		if(direction == 1){
			if(posY < MAX_SIZE)
				posY++;
			else
				posY--;
		}
		if(direction == 2){
			if(posX < MAX_SIZE)
				posX++;
			else
				posX--;
		}
		if(direction == 3){
			if(posY > MIN_SIZE)
				posY--;
			else
				posY++;
		}
	}

	public void destroy(){
		destroyed = true;
	}

	public boolean isDestroyed(){
		return destroyed;
	}
	
	public String toString() {
		return "["+ id +"] " + "(" + posX+","+posY+") " + (estOccupee()?"occupée ("+conducteur+")"  : "libre") + " " + (estAllumee()?"allumée":"éteinte") + " " +(estClignotante()?"clignotante":"non clignotante");
	}

	public String toStringSimple(){
		return "["+this.getId()+"] " + this.getNomOccupant();
	}

	public int ajouteOccupant (String nom){
		if(estOccupee())
			return 1;
		else{
			conducteur = nom;
			return 0;
		}
	}

	public int enleveOccupant (){
		if(estOccupee()){
			conducteur = "";
			return 0;
		}
		else
			return 0;
	}

	public int allume(){
		if(estAllumee())
			return 1;
		else{
			power = true;
			return 0;
		}
	}

	public int eteint(){
		if(!estAllumee())
			return 1;
		else{
			power = false;
			return 0;
		}
	}

	public int demarreClignotement(){
		if(estClignotante())
			return 1;
		else{
			blink = true;
			return 0;
		}
	}

	public int arreteClignotement(){
		if(!estClignotante())
			return 1;
		else{
			blink = false;
			return 0;
		}
	}
}
