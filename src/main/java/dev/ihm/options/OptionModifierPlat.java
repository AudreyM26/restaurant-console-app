package dev.ihm.options;

import java.util.Scanner;

import dev.entite.Plat;
import dev.exception.PlatException;
import dev.service.IPlatService;

public class OptionModifierPlat implements IOptionMenu {
	
	private Scanner scanner;

    private IPlatService service;
    
	public OptionModifierPlat(Scanner scanner, IPlatService service) {
        this.scanner = scanner;
        this.service = service;
    }
	
	@Override
	public String getTitre() {
		return "Modifier le plat";
	}

	@Override
	public void executer() {
		
		boolean saisieKO = true;
		Integer id=0;
        while (saisieKO) {
        	
        	System.out.println("Saisissez l' id du plat à modifier :");

			while (!this.scanner.hasNextInt()) {	
				this.scanner.next();
				System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
				System.out.println("Saisissez l' id du plat à modifier :");
		    }
        	
			id = this.scanner.nextInt();
			
            System.out.println("Saisissez le nom du plat (sans espaces) (Tapez 'n' si aucun changement) :");
          
            String nomPlat="";
            String saisieNom = this.scanner.next();
            
            if(!saisieNom.equalsIgnoreCase("n")){
            	nomPlat=saisieNom;
            }

            System.out.println("Saisissez le prix en centimes d'euros (Tapez 'n' si aucun changement) :");
            Integer prix =0;
          
            String saisiePrix = this.scanner.next();
            
            if(!saisiePrix.equalsIgnoreCase("n")){
            	prix=Integer.parseInt(saisiePrix);
            }

            try {
            	Plat plat= new Plat();
            	plat.setId(id);
            	if(!nomPlat.equals("")){
            		plat.setNom(nomPlat);
            	}
            	if(prix!=0){
            		plat.setPrixEnCentimesEuros(prix);
            	}
            	
                this.service.modifierPlat(plat);
                saisieKO = false;
            } catch (PlatException e) {
                System.out.println(e.getMessage());
            }
        }
	}

}
