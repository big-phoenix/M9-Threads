package com.coets.main;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.coets.interfaces.CoetsDAO;
import com.coets.project.Coets;
import com.coets.project.CoetsDAOImpl;



public class DAOPatterCoets {
	
	static CoetsDAO cohetesDAO;
	
	public static void main(String[] args) {
		
		cohetesDAO = new CoetsDAOImpl();
		
		String numero = JOptionPane.showInputDialog(null,"Introduce cuantos Cohetes vas a introducir");
		int num = Integer.parseInt(numero);
	
		for(int i=0; i<num; i++) {
			cohetesDAO.addCoet();
		}
		
		for(Coets cohetes: cohetesDAO.getAllCoets()) {
			System.out.println("Cohete: [Codigo : " + cohetes.getCodigo() + ", Propulsores : " + cohetes.getPropulsores() + 
					", Potencia acutual : " + cohetes.getPotenciaActual() + " ]");
			
			System.out.println("-----------------------------------------------------------------------------------");
			
		}
		
		String potencia = JOptionPane.showInputDialog(null,"Introduce la potencia Total");
		int pot = Integer.parseInt(potencia);
		
	
		while(true) {
			
			String[] propulsor = {
		            "Acelerar",
		            "Frenar"
		    };
			
			ImageIcon icono = new ImageIcon("img/icon.png");
			
			String tipo = (String) JOptionPane.showInputDialog(null, 
	        		"¿Que quieres hacer con los Cohetes?", "Cohete", JOptionPane.DEFAULT_OPTION, 
	        		icono, propulsor, propulsor[0]);
			
			switch(tipo) {
			
			case "Acelerar":
				try {
				
							for(Coets cohetes: cohetesDAO.getAllCoets()) {
								
								cohetes.setPotencia(pot);
								
								try {
									Thread.sleep(500);
									
									for(int i=0; i<cohetes.getPropulsores().size(); i++) {
										
										
										int j = i;
										
										new Thread(new Runnable() {

											@Override
											public void run() {
												
												//System.out.println(j+" "+Thread.currentThread().getName());
												
												System.out.print("Cohete "+cohetes.getCodigo()+ " - "+j+" Propulsores "+cohetes.getPropulsores()+" - ");
												System.out.println(cohetes.getPotenciaActual());
												
												//while(cohetes.Acelerar(j) == true) {
													
													try {
														Thread.sleep(500);
														cohetes.Acelerar(j);
														System.out.println("Cohete "+cohetes.getCodigo()+ " - "+j+" Propulsores "+cohetes.getPotenciaActual());
													} catch (Exception e) {
														System.out.println("Algo falla en la aceleracion");
													}
													
												//}
												
												
												
											}
											
										}).start();
										
									}
									
									
								}catch(InterruptedException e){
									Thread.currentThread().interrupt();
									System.out.println(" Fallo, interrumpido el porceso ");
								}
								
							}
						
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			break;
			
			case "Frenar":
				try {
					
					for(Coets cohetes: cohetesDAO.getAllCoets()) {
						
						try {
							Thread.sleep(500);
							
							for(int i=0; i<cohetes.getPropulsores().size(); i++) {
								
								
								int j = i;
								
								new Thread(new Runnable() {

									@Override
									public void run() {
										
										//System.out.println(j+" "+Thread.currentThread().getName());
										
										System.out.print("Cohete "+cohetes.getCodigo()+ " - "+j+" Propulsores "+cohetes.getPropulsores()+" - ");
										System.out.println("Potencia actual: "+cohetes.getPotenciaActual());

										
										while(cohetes.Frenar(j) == true) {
											
											try {
												Thread.sleep(500);
												cohetes.Frenar(j);
												System.out.println("Cohete "+cohetes.getCodigo()+" Propulsores "+cohetes.getPotenciaActual());
											} catch (Exception e) {
												System.out.println("Algo falla en la aceleracion");
											}
											
										}
										
										System.out.println("Cohete "+cohetes.getCodigo()+" Propulsor "+(j+1)+" parado");
										
									}
									
								}).start();
								
							}
							
							
						}catch(InterruptedException e){
							Thread.currentThread().interrupt();
							System.out.println(" Fallo, interrumpido el porceso ");
						}
						
					}
				
			
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			break;

			}
			
		}
		
		
	}
	
}
