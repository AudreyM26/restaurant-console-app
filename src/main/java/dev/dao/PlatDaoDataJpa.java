package dev.dao;

import java.util.List;

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

}
