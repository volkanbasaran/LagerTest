package de.lager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.lager.model.Lager;
import de.lager.repository.LagerRepository;

@RestController
@RequestMapping(value = "/lager")
public class LagerController {

	@Autowired
	LagerRepository lagerrepo;

	@GetMapping(value = "/", produces = "application/json")
	public String hallo() {
		return "Hallo! Ich bin der Volkan :) !";
	}

	// Ausgabe aller Bestellungen
	@GetMapping(value = "/all", produces = "application/json")
	public List<Lager> getAllOrders() {
		return lagerrepo.findAll();
	}

	// Bestellungen nach seiner ID ausgeben
	@GetMapping(value = "/findbyid/{id}", produces = "application/json")
	public Optional<Lager> findById(@PathVariable("id") Integer id, Lager et) {
		id = et.getId();
		return lagerrepo.findById(id);
	}
	
	// Suche per Artikelname
	@GetMapping(value = "/searchartikelname", produces = "application/json")
	List<Lager> findByArtikelname(@RequestParam(value="artikelname") String artikelname) {
		return lagerrepo.findByArtikelname(artikelname);
	}

	// Einen Artikel hinzufügen
	@PostMapping(value = "/post/{hersteller}/{modell}/{baujahr}/{artikelname}/{ekpreis}/{verkpreis}/{mengeverfuegbar}", produces = "application/json")
	public String load(@PathVariable String hersteller, String modell, String baujahr, String artikelname,
			double ekpreis, double verkpreis, Integer mengeverfuegbar, Lager bestand) {

		hersteller = bestand.getHersteller();
		modell = bestand.getModell();
		baujahr = bestand.getBaujahr();
		artikelname = bestand.getArtikelname();
		ekpreis = bestand.getEkpreis();
		verkpreis = bestand.getVerkpreis();
		mengeverfuegbar = bestand.getMengeverfuegbar();

		Lager lager = new Lager(hersteller, modell, baujahr, artikelname, ekpreis, verkpreis, mengeverfuegbar);
		lagerrepo.save(lager);

		return "Artikel = " + lager.getArtikelname() + " erfolgreich zum Lager hinzugefügt!";
	}

	// Einen Artikel aus dem Bestand löschen
	@DeleteMapping(value = "/deletebyid/{id}", produces = "application/json")
	public String deleteById(@PathVariable("id") Integer id) {
		Lager a = lagerrepo.getOne(id);
		lagerrepo.delete(a);
		return "Artikel wurde erfolgreich gelöscht!";
	}

	// Einen Artikel aus dem Bestand ändern
	@PutMapping(value = "/update", produces = "application/json")
	public Lager update(@RequestBody Lager be) {
		lagerrepo.save(be);
		return be;
	}

}
