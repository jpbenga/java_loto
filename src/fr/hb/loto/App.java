package fr.hb.loto;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

	// Attributs
	private static final int NB_CASES_DE_LA_GRILLE = 5;
	private static int[] tirage = new int[NB_CASES_DE_LA_GRILLE];
	private static int[] grilleDuJoueur = new int[NB_CASES_DE_LA_GRILLE];
	private static Random random = new Random();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		for(int i = 0; i < tirage.length; i++) {
			tirage[i] = random.nextInt(1, 50);
			for(int j = i; j < i; j++) {
				if(tirage[j] == tirage[i] && i != j) {
					i--;
				}
			}
		}

		int i = 0;

		System.out.println("-----------------");
		System.out.println("Bienvenue sur le loto! Veuillez saisir votre grille");
		while (i != 5) {
			// Bien vérifier que le joueur a choisi des nombres distincts compris entre 1 et
			// 49
			System.out.println("choix n° " + (i + 1));
			grilleDuJoueur[i] = sc.nextInt();
			if (grilleDuJoueur[i] < 1 || grilleDuJoueur[i] > 49) {
				System.out.println("Veuillez saisir un nombre compris entre 1 et 49");

			} else {
				boolean possedeDoublon = false;
				for (int j = 0; j < i; j++) {
					if (grilleDuJoueur[i] == grilleDuJoueur[j]) {
						System.out.println("Vous avez saisi 2 fois le même nombre");
						possedeDoublon = true;
						break;
					}
				}
				if (!possedeDoublon) {
					i++;					
				}
			}

		}
		
		System.out.println("Voici votre grille de loto :");
		for (int nombre : grilleDuJoueur) {
		    System.out.print("[" + nombre +"]" + " ");
		}
		System.out.println("\n");
		
		System.out.println("Voici le tirage:");
		for(int nombre : tirage) {
			System.out.print("[" + nombre +"]" + " ");
		}
		
		int count = 0;
		List<Integer> correctTab = new ArrayList<>();
		
		for(int g : grilleDuJoueur) {
			for(int t : tirage) {
				if(g == t) {
			        System.out.println(g);
			        correctTab.add(g);
					count ++;
				}
			}
		}
		System.out.println("\n");
		switch (count) {
		case 0: 
			System.out.println("Vous n'avez aucun bon numéro");
			break;
		case 1: 
			System.out.println("Vous avez 1 bon numéro");
			break;
		case 2: 
			System.out.println("Vous avez 2 bon numéro");
			break;
		case 3: 
			System.out.println("Vous avez 3 bon numéro");
			break;
		case 4: 
			System.out.println("Vous avez 4 bon numéro, vous y étiez presque");
			break;
		case 5: 
			System.out.println("Félicitation, vous venez de remporter ce loto!!!");
			break;
			
		}
		System.out.println("\n");
		
		for(int number : correctTab) {
			System.out.print("\u001B[32m");
			System.out.println("[" + number + "]" + " ");
		}
		System.out.println();
		sc.close();
	}
}