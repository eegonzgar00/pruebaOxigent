/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.corporate.knowledge.test.service.impl;

import com.corporate.knowledge.test.exception.NoSuchCandidateException;
import com.corporate.knowledge.test.model.Candidate;
import com.corporate.knowledge.test.model.impl.CandidateImpl;
import com.corporate.knowledge.test.service.base.CandidateLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the candidate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.corporate.knowledge.test.service.CandidateLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CandidateLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.corporate.knowledge.test.model.Candidate", service = AopService.class)
public class CandidateLocalServiceImpl extends CandidateLocalServiceBaseImpl {

	static Logger log = Logger.getLogger(CandidateLocalServiceImpl.class.getName());
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.corporate.knowledge.test.service.CandidateLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.corporate.knowledge.test.service.CandidateLocalServiceUtil</code>.
	 */

	// TODO Ejercicio 3.a Modifica el m??todo getAllCandidatesOrdered del servicio CandidateLocalServiceImpl para que obtenga todos los candidatos y los devuelva
	// ordenados de forma alfabeticamente ascendente por nombre usando streams y expresiones lambda de Java 8
	@Override
	public List<Candidate> getAllCandidatesOrdered() {
		List<Candidate> candidatesList=	candidatePersistence.findAll();
		List<Candidate> sortedCopy = new ArrayList(candidatesList);
        Collections.sort(sortedCopy, (x, y) -> x.getName().compareToIgnoreCase(y.getName()));
	   	return sortedCopy;
	}


	// TODO Ejercicio 2.c Crea un nuevo m??todo mediante el service builder en el servicio CandidateLocalServiceImpl que, a partir del candidateId, permita
	// cambiar el name de un candidato

	@Override
	public boolean updateCandidateById(long candidateId,String name) {
		 boolean bandera =  false;
		try {
			Candidate candidate = candidatePersistence.findByPrimaryKey(candidateId);
			candidate.setName(name);
			candidatePersistence.update(candidate);
			bandera = true;
		} catch (NoSuchCandidateException e) {
			// TODO Auto-generated catch block
			log.info("No se pudo realizar la actualizacion del nombre para el id del canditado " + candidateId);
			log.info("Error:" + e.getStackTrace());
			
		}

		 return bandera;
	}
	
	@Override
	public void crearCandidato(String company , String name) {
		log.info("Ingreso a crear candidato:");
		boolean bandera =  false;
		int numero = (int)(Math.random()*100+1);
		Candidate candidate = candidatePersistence.create(numero);
		candidate.setCandidateId(numero);
		candidate.setName(name);
		candidate.setCompany(company);
		candidate.setPassed(true);
		candidate.setLocation("Colombia");
		candidatePersistence.update(candidate);
		log.info("Finalizo con exito la creacion del candidato");
	}
}