package com.coets.project;

import java.util.*;

public class Coets {
	
	String codigo;
	List<Integer> propulsores = new ArrayList<Integer>();
	List<Integer> potenciaActual = new ArrayList<Integer>();
	private Thread thread;
	
	public Coets(String codigo, List<Integer> propulsores, List<Integer> potenciaActual) {
		
		this.codigo = codigo;
		this.propulsores = propulsores;
		this.potenciaActual = potenciaActual;
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public List<Integer> getPropulsores() {
		return propulsores;
	}
	
	public void setPropulsores(List<Integer> propulsores) {
		this.propulsores = propulsores;
	}
	
	public List<Integer> getPotenciaActual() {
		return potenciaActual;
	}
	
	public void setPotenciaActual(int index, int valor) {
		this.potenciaActual.set(index, valor);
	}
	
	public String getDatosCoetes() {
		return "El Cohete: " +codigo+ " tiene " +propulsores+ " propulsores y potencias " +potenciaActual;
	}
	
	public boolean Acelerar(int propulsor) {
		
		boolean star = true;
		
		if(getPotenciaActual().get(propulsor) != getPropulsores().get(propulsor)) {
			setPotenciaActual(propulsor, getPotenciaActual().get(propulsor)+1);
		}else {
			star=false;
		}
	
		return star;
	}
	
	public boolean Frenar(int propulsor) {
		
		boolean stop = true;
		
		if(getPotenciaActual().get(propulsor) != 0) {
			setPotenciaActual(propulsor, getPotenciaActual().get(propulsor)-1);
		}else {
			
			stop=false;
		}
	
		return stop;
		
	}

}
