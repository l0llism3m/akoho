package com.xadmin.usermanagement.bean;

public class Admin {
	private int id_ad;
	private String nom;
	private String email;
	private String motPasse;
	
	
	public Admin( String email, String motPasse) {
		super();
		this.email = email;
		this.motPasse = motPasse;
	}
	
	public Admin(int id_ad, String nom, String email, String motPasse) {
		super();
		this.id_ad = id_ad;
		this.nom = nom;
		this.email = email;
		this.motPasse = motPasse;
	}
	
	

	public int getId_ad() {
		return id_ad;
	}
	public void setId_ad(int id_ad) {
		this.id_ad = id_ad;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotPasse() {
		return motPasse;
	}
	public void setMotPasse(String motPasse) {
		this.motPasse = motPasse;
	}
}
