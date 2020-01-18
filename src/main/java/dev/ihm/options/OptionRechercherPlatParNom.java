package dev.ihm.options;

import java.util.Scanner;

import dev.exception.PlatException;
import dev.service.IPlatService;

public class OptionRechercherPlatParNom implements IOptionMenu {

	private Scanner scanner;
	private IPlatService service;

    public OptionRechercherPlatParNom(Scanner scanner,IPlatService service) {
        this.scanner =scanner;
    	this.service = service;
    }
    
	@Override
	public String getTitre() {
		return "Rechercher par nom";
	}

	@Override
	public void executer() {
		boolean saisieKO = true;

        while (saisieKO) {

            System.out.println("Saisissez le nom du plat :");
            String nomPlat = this.scanner.next();

            try {

            	this.service.rechercherPlatParNom(nomPlat).forEach(plat -> {
            		System.out.println(plat.getId()+" - "+plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)\n");
                });
            	
            	if(this.service.rechercherPlatParNom(nomPlat).size()<1){
            		System.out.println("Aucun plat n'a été trouvé\n");
            	}
            	saisieKO=false;
 
            } catch (PlatException e) {
                System.out.println(e.getMessage());
            }
        }
		
	}

}
