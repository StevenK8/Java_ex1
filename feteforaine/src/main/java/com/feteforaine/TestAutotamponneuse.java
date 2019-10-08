package com.feteforaine;

public class TestAutotamponneuse {
	public static void main(String[] args){
		Autotamponneuse a1 = new Autotamponneuse(90, 10);
		System.out.println(a1);
		Autotamponneuse a2 = new Autotamponneuse(83, 15);
		a2.ajouteOccupant("Flash McQueen");
		System.out.println(a2);
		Autotamponneuse a3 = new Autotamponneuse(5, 18);
		Autotamponneuse a4 = new Autotamponneuse(10, 15);
		a3.ajouteOccupant("Alain Terrieur");
		a3.demarreClignotement();
		a3.allume();
		System.out.println(a3);

		System.out.println(a2.equals(a4));
		System.out.println(Autotamponneuse.collision(a3, a4));
	}
}
