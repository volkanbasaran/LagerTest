package de.lager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.lager.model.Lager;

public interface LagerRepository extends JpaRepository<Lager, Integer> {

	// Suche per Artikelname
	List<Lager> findByArtikelname(String artikelname);
}
