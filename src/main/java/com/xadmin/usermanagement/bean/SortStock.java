package com.xadmin.usermanagement.bean;

public class SortStock {
	private int id_sort;
	private String nom_pers;
	private String nom_prodt;
	private int quantiter;
	private String date_sort;
	
	
	public SortStock(int id_sort, String nom_pers, String nom_prodt, int quantiter, String date_sort) {
		super();
		this.id_sort = id_sort;
		this.nom_pers = nom_pers;
		this.nom_prodt = nom_prodt;
		this.quantiter = quantiter;
		this.date_sort = date_sort;
	}
	
	
	public SortStock(String nom_pers, String nom_prodt, int quantiter, String date_sort) {
		super();
		this.nom_pers = nom_pers;
		this.nom_prodt = nom_prodt;
		this.quantiter = quantiter;
		this.date_sort = date_sort;
	}

	
	
	public int getId_sort() {
		return id_sort;
	}
	public void setId_sort(int id_sort) {
		this.id_sort = id_sort;
	}
	public String getNom_pers() {
		return nom_pers;
	}
	public void setNom_pers(String nom_pers) {
		this.nom_pers = nom_pers;
	}
	public String getNom_prodt() {
		return nom_prodt;
	}
	public void setNom_prodt(String nom_prodt) {
		this.nom_prodt = nom_prodt;
	}
	public int getQuantiter() {
		return quantiter;
	}
	public void setQuantiter(int quantiter) {
		this.quantiter = quantiter;
	}
	public String getDate_sort() {
		return date_sort;
	}
	public void setDate_sort(String date_sort) {
		this.date_sort = date_sort;
	}
	
	
	
	
	
}
