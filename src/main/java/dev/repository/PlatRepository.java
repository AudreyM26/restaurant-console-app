package dev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Indexed;

import dev.entite.Plat;


public interface PlatRepository extends JpaRepository<Plat, Integer> {
	
	List<Plat> findByNom(String nom);
}
