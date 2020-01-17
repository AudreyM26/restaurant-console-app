package dev.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dev.entite.Plat;

@Repository

public class PlatDaoJpa implements IPlatDao {

	// injecter une instance d'EntityManager
	@PersistenceContext private EntityManager em;
	
	@Override
	public List<Plat> listerPlats() {
		TypedQuery<Plat> query = em.createQuery("SELECT p from Plat p",Plat.class);
		List<Plat> result = query.getResultList();
	    return result;
	}

	@Transactional
	public void ajouterPlat(String nomPlat, Integer prixPlat) {
		// TODO Auto-generated method stub
		Plat plat = new Plat();
		plat.setNom(nomPlat);
		plat.setPrixEnCentimesEuros(prixPlat);
		em.persist(plat);
	}

}
