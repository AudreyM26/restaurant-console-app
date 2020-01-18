package dev.dao;

import dev.entite.Plat;
import dev.exception.PlatException;

import java.util.List;
import java.util.Optional;

public interface IPlatDao {
    List<Plat> listerPlats();
    void ajouterPlat(String nomPlat, Integer prixPlat);
    default Plat rechercherPlatParId(Integer id){
    	throw new PlatException("Fonction non implémentée");
    }
    default List<Plat> rechercherPlatParNom(String nom){
    	throw new PlatException("Fonction non implémentée");
    }
    default void modifierPlat(Plat plat){
    	throw new PlatException("Fonction non implémentée");
    }
    default void supprimerPlat(Integer id){
    	throw new PlatException("Fonction non implémentée");
    }
}
