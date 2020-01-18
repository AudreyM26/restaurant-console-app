package dev.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.entite.Plat;
import dev.repository.PlatRepository;

@Repository
public class PlatDaoDataJpa implements IPlatDao {

	@Autowired PlatRepository pPlat;
	
	
	public List<Plat> listerPlats() {
		return pPlat.findAll();
	}


	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		Plat plat = new Plat();
		plat.setNom(nomPlat);
		plat.setPrixEnCentimesEuros(prixPlat);
		pPlat.save(plat);
	}

	public Plat rechercherPlatParId(Integer id){
		Plat plat=null;
		if(pPlat.existsById(id)){
			plat = pPlat.findById(id).get();
		}
		return plat;
	}
	
	public List<Plat> rechercherPlatParNom(String nom){
		return pPlat.findByNom(nom);
	}
	
	public void modifierPlat(Plat plat){
		if(pPlat.existsById(plat.getId())){
			
			if(plat.getNom()==null){
				String nomPlat = pPlat.findById(plat.getId()).get().getNom();
				plat.setNom(nomPlat);
			}
			
			if(plat.getPrixEnCentimesEuros()==null){
				Integer prixPlat =  pPlat.findById(plat.getId()).get().getPrixEnCentimesEuros();
				plat.setPrixEnCentimesEuros(prixPlat);
			}
			
			pPlat.save(plat);
		}else{
			System.out.println("Le plat n'a pas pu être modifié\n");
		}
	}
	
	public void supprimerPlat(Integer id){
		if(pPlat.existsById(id)){
			pPlat.deleteById(id);
		}else{
			System.out.println("Le plat n'existe pas\n");
		}
	}
}
