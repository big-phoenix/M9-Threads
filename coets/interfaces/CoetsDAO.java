package com.coets.interfaces;

import java.util.*;

import com.coets.project.Coets;

public interface CoetsDAO {
	
	public List<Coets> getAllCoets();
	public Coets getCoet(String codigo);
	public Coets getCoetPosiscion(int posicion);
	public void addCoet();

}
