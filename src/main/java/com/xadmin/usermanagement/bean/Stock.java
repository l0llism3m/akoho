package com.xadmin.usermanagement.bean;

public class Stock {
	private int id_stk;
	private String nom_persn;
	private String nom_prod;
	private String ref_prod;
	private int quant_stk;
	private int prix_unit;
	private String date_stk;
	
	

	public Stock(String nom_persn, String nom_prod, String ref_prod, int quant_stk, int prix_unit, String date_stk) {
		super();
		this.nom_persn = nom_persn;
		this.nom_prod = nom_prod;
		this.ref_prod = ref_prod;
		this.quant_stk = quant_stk;
		this.prix_unit = prix_unit;
		this.date_stk = date_stk;
	}


	public Stock(int id_stk, String nom_persn, String nom_prod, String ref_prod, int quant_stk, int prix_unit,
			String date_stk) {
		super();
		this.id_stk = id_stk;
		this.nom_persn = nom_persn;
		this.nom_prod = nom_prod;
		this.ref_prod = ref_prod;
		this.quant_stk = quant_stk;
		this.prix_unit = prix_unit;
		this.date_stk = date_stk;
	}
	
	
	public int getId_stk() {
		return id_stk;
	}
	public void setId_stk(int id_stk) {
		this.id_stk = id_stk;
	}
	public String getNom_persn() {
		return nom_persn;
	}
	public void setCin_persn(String cin_persn) {
		this.nom_persn = cin_persn;
	}
	public String getNom_prod() {
		return nom_prod;
	}
	public void setNom_prod(String nom_prod) {
		this.nom_prod = nom_prod;
	}
	public String getRef_prod() {
		return ref_prod;
	}
	public void setRef_prod(String ref_prod) {
		this.ref_prod = ref_prod;
	}
	public int getQuant_stk() {
		return quant_stk;
	}
	public void setQuant_stk(int quant_stk) {
		this.quant_stk = quant_stk;
	}
	public int getPrix_unit() {
		return prix_unit;
	}
	public void setPrix_unt(int prix_unit) {
		this.prix_unit = prix_unit;
	}
	public String getDate_stk() {
		return date_stk;
	}
	public void setDate_stk(String date_stk) {
		this.date_stk = date_stk;
	}
}

