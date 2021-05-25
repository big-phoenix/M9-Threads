package com.coets.project;

import java.util.*;

public class Coets {
	
	String codigo;
	List<Integer> propulsores = new ArrayList<Integer>();
	List<Integer> potenciaActual = new ArrayList<Integer>();
	private int velocidad;
	
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
	
	public void setPotencia(int maxPotencia) {
		velocidad = (int) (10 * Math.sqrt(maxPotencia));
	}
	
	
	public void Acelerar(int propulsor) {
		
		int normalizacion = velocidad/propulsores.size();
		
		System.out.println(propulsores.get(propulsor));
		
		for(int i=0; i<=normalizacion;i++) {
				
			if(propulsores.get(propulsor) == potenciaActual.get(propulsor)) {
				System.out.println("Cohete "+codigo+" Propulsor "+propulsor+" a tope FALTA DE POTENCIA");
			}else {
				
				setPotenciaActual(propulsor, getPotenciaActual().get(propulsor)+1);
				System.out.println("Cohete "+codigo+ " - "+propulsor+" Propulsores "+potenciaActual);
			}
				
		}
		
		
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
