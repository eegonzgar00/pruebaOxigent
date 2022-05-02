package com.corporate.knowledge.test.helper.impl;

import com.corporate.knowledge.test.helper.ICandidateHelperService;

import org.osgi.service.component.annotations.Component;

//TODO Ejercicio 1.a: Añadir las anotaciones necesarias para que se genere el servicio CandidateHelperServiceImpl como componente OSGi
@Component(
	    immediate = true,
	    service = ICandidateHelperService.class
	)
public class CandidateHelperServiceImpl implements ICandidateHelperService {

	@Override
	public boolean validateName(String name) {
		// TODO Ejercicio 1.c Implementar un metodo que valide el nombre no sea nulo y tenga una longitud entre 1 y 20 caracteres
		boolean longitudValida = false;
		if(name != null && name != "" && name.length()  <= 20) {
				longitudValida = true;
		}
		return longitudValida;
	}

}
