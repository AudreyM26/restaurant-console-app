package dev.ihm.options;

import java.util.Scanner;

import dev.exception.PlatException;
import dev.service.IPlatService;

public class OptionSupprimerPlat implements IOptionMenu {

	private Scanner scanner;

	private IPlatService service;

	public OptionSupprimerPlat(Scanner scanner, IPlatService service) {
		this.scanner = scanner;
		this.service = service;
	}

	@Override
	public String getTitre() {
		return "Supprimer un plat";
	}

	@Override
	public void executer() {
		boolean saisieKO = true;
		Integer id=0;
		while (saisieKO) {
			
			System.out.println("Saisissez l' id du plat à supprimer :");

			while (!this.scanner.hasNextInt()) {	
				this.scanner.next();
				System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
				System.out.println("Saisissez l' id du plat à supprimer :");
		    }
			
			try {
				id = this.scanner.nextInt();
				this.service.supprimerPlat(id);
				saisieKO = false;
			} catch (PlatException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
