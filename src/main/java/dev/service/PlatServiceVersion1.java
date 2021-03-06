package dev.service;

import dev.dao.IPlatDao;
import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PlatServiceVersion1 implements IPlatService {
	
    private IPlatDao dao;

 
    public PlatServiceVersion1 (@Qualifier("platDaoDataJpa") IPlatDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Plat> listerPlats() {
        return dao.listerPlats();
    }

    @Override
    public void ajouterPlat(String nomPlat, Integer prixPlat) {

        // règle métier

        if (nomPlat.length() <= 3) {
            throw new PlatException("un plat doit avoir un nom de plus de 3 caractères");
        }

        if (prixPlat <= 500) {
            throw new PlatException("le prix d'un plat doit être supérieur à 5 €");
        }

        // persistance uniquement si les règles métiers sont respectées
        dao.ajouterPlat(nomPlat, prixPlat);
    }
 
    
    public Plat rechercherPlatParId(Integer id){
    	return dao.rechercherPlatParId(id);
    }
    
    public List<Plat> rechercherPlatParNom(String nom){
    	return dao.rechercherPlatParNom(nom);
    }
    
    @Override
    public void modifierPlat(Plat plat) {
    	
    	// règle métier
        if (plat.getNom() != null && plat.getNom().length() <= 3) {
            throw new PlatException("un plat doit avoir un nom de plus de 3 caractères");
        }

        if (plat.getPrixEnCentimesEuros() != null && plat.getPrixEnCentimesEuros() <= 500) {
            throw new PlatException("le prix d'un plat doit être supérieur à 5 €");
        }
    	
    	dao.modifierPlat(plat);
    }
    
    @Override
    public void supprimerPlat(Integer id) {
    	dao.supprimerPlat(id);
    }
}
