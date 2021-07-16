package it.polito.tdp.anagrammi.model;

import java.util.List;


public class TestModel {
	public static void main(String args[]) {
		Model a = new Model();
		
		List<String> anagrammi ;
		
		anagrammi = a.anagrammi("dog") ;
		System.out.println(anagrammi) ;
		anagrammi = a.anagrammi("cinque") ;
		System.out.println(anagrammi) ;
	}

}
