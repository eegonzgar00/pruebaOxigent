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

package com.corporate.knowledge.test.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.corporate.knowledge.test.service.http.CandidateServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CandidateSoap implements Serializable {

	public static CandidateSoap toSoapModel(Candidate model) {
		CandidateSoap soapModel = new CandidateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setName(model.getName());
		soapModel.setCompany(model.getCompany());
		soapModel.setPassed(model.isPassed());
		soapModel.setPoints(model.getPoints());
		soapModel.setTestDate(model.getTestDate());
		soapModel.setLocation(model.getLocation());

		return soapModel;
	}

	public static CandidateSoap[] toSoapModels(Candidate[] models) {
		CandidateSoap[] soapModels = new CandidateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[][] toSoapModels(Candidate[][] models) {
		CandidateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[] toSoapModels(List<Candidate> models) {
		List<CandidateSoap> soapModels = new ArrayList<CandidateSoap>(
			models.size());

		for (Candidate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateSoap[soapModels.size()]);
	}

	public CandidateSoap() {
	}

	public long getPrimaryKey() {
		return _candidateId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public boolean getPassed() {
		return _passed;
	}

	public boolean isPassed() {
		return _passed;
	}

	public void setPassed(boolean passed) {
		_passed = passed;
	}

	public int getPoints() {
		return _points;
	}

	public void setPoints(int points) {
		_points = points;
	}

	public Date getTestDate() {
		return _testDate;
	}

	public void setTestDate(Date testDate) {
		_testDate = testDate;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	private String _uuid;
	private long _candidateId;
	private String _name;
	private String _company;
	private boolean _passed;
	private int _points;
	private Date _testDate;
	private String _location;

}