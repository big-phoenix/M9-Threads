package com.coets.project;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.coets.interfaces.CoetsDAO;

public class CoetsDAOImpl implements CoetsDAO{
	
	public List<Coets> cohetes = new ArrayList<Coets>();

	@Override
	public List<Coets> getAllCoets() {
		// TODO Auto-generated method stub
		return cohetes;
	}

	@Override
	public Coets getCoet(String codigo) {
		
		Coets datos = null;
		
		for(int i=0; i < cohetes.size();i++) {
			
			String nombres = cohetes.get(i).getCodigo();
				
				if(nombres.equals(codigo)) {
					datos = cohetes.get(i);
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return datos;
		
	}
	
	@Override
	public Coets getCoetPosiscion(int posicion) {
		
		Coets datos = null;
		
		for(int i=0; i < cohetes.size();i++) {
			
			datos = cohetes.get(posicion);

		}
		
		return datos;
		
	}


	@Override
	public void addCoet() {
		
		List<Integer> propulsores = new ArrayList<Integer>();
		List<Integer> potenciaActual = new ArrayList<Integer>();
		Coets cohete;
		
			
			String codigo = JOptionPane.showInputDialog(null,"Introduce el codigo del Cohete");
			String numeroPropulsor = JOptionPane.showInputDialog(null,"Introduce el numero de Propulsores");
			
			int propul = Integer.parseInt(numeroPropulsor);
			
			for(int i=0; i<propul; i++) {
				String potencias = JOptionPane.showInputDialog(null,"Introduce la potencia del Propulsor "+(i+1));
				int potencia = Integer.parseInt(potencias);
				
				propulsores.add(potencia);
				potenciaActual.add(0);
				
			}
			
			cohete = new Coets(codigo, propulsores, potenciaActual);
			this.cohetes.add(cohete);
		
			
	}

}
