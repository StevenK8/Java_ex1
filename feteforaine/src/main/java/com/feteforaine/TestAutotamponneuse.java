package com.feteforaine;

public class TestAutotamponneuse {
	public static void main(String[] args){
		Autotamponneuse a1 = new Autotamponneuse(110, 10);
		System.out.println(a1);
		Autotamponneuse a2 = new Autotamponneuse(83, 15);
		a2.setDriver("Flash McQueen");
		System.out.println(a2);
		Autotamponneuse a3 = new Autotamponneuse(5, 18);
		a3.setDriver("Alain Terrieur");
		a3.setPower(true);
		a3.setBlink(true);
		System.out.println(a3);
	}
}
