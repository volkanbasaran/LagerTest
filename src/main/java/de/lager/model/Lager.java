package de.lager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="lager")
public class Lager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "hersteller")
	private String hersteller;
	
	@Column(name = "modell")
	private String modell;
	
	@Column(name = "baujahr")
	private String baujahr;

	@Column(name = "artikelname")
	private String artikelname;

	@Column(name = "ekpreis")
	private double ekpreis;

	@Column(name = "verkpreis")
	private double verkpreis;

	@Column(name = "mengeverfuegbar")
	private Integer mengeverfuegbar;

	// Konstruktor
	public Lager() {

	}

	public Lager(String hersteller, String modell, String baujahr, String artikelname, double ekpreis,
			double verkpreis, Integer mengeverfuegbar) {
		super();
		this.hersteller = hersteller;
		this.modell = modell;
		this.baujahr = baujahr;
		this.artikelname = artikelname;
		this.ekpreis = ekpreis;
		this.verkpreis = verkpreis;
		this.mengeverfuegbar = mengeverfuegbar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHersteller() {
		return hersteller;
	}

	public void setHersteller(String hersteller) {
		this.hersteller = hersteller;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getBaujahr() {
		return baujahr;
	}

	public void setBaujahr(String baujahr) {
		this.baujahr = baujahr;
	}

	public String getArtikelname() {
		return artikelname;
	}

	public void setArtikelname(String artikelname) {
		this.artikelname = artikelname;
	}

	public double getEkpreis() {
		return ekpreis;
	}

	public void setEkpreis(double ekpreis) {
		this.ekpreis = ekpreis;
	}

	public double getVerkpreis() {
		return verkpreis;
	}

	public void setVerkpreis(double verkpreis) {
		this.verkpreis = verkpreis;
	}

	public Integer getMengeverfuegbar() {
		return mengeverfuegbar;
	}

	public void setMengeverfuegbar(Integer mengeverfuegbar) {
		this.mengeverfuegbar = mengeverfuegbar;
	}
}
