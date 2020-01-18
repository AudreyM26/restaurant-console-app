package dev.ihm.options;

import java.util.Scanner;

import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.IPlatService;

public class OptionRechercherPlatParId implements IOptionMenu {

	private Scanner scanner;
	private IPlatService service;

    public OptionRechercherPlatParId(Scanner scanner,IPlatService service) {
    	this.scanner = scanner;
    	this.service = service;
    }
	    
	@Override
	public String getTitre() {
		return "Rechercher par id";
	}

	@Override
	public void executer() {
		
		boolean saisieKO = true;

        while (saisieKO) {

            System.out.println("Saisissez l' id du plat :");
            Integer id = this.scanner.nextInt();

            try {

                Plat plat = null;
                if(this.service.rechercherPlatParId(id)!=null){
                	plat = this.service.rechercherPlatParId(id);
                }
                saisieKO = false;
                if(plat !=null){
                	System.out.println(plat.getId()+" - "+plat.getNom() + " (" + (plat.getPrixEnCentimesEuros() / 100) + " €)\n");
                }else{
                	System.out.println("Le plat n'existe pas\n");
                }
            } catch (PlatException e) {
                System.out.println(e.getMessage());
            }
        }

	}
}
