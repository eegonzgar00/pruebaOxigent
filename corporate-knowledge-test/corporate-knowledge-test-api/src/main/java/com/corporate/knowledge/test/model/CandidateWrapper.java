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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Candidate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Candidate
 * @generated
 */
@ProviderType
public class CandidateWrapper
	extends BaseModelWrapper<Candidate>
	implements Candidate, ModelWrapper<Candidate> {

	public CandidateWrapper(Candidate candidate) {
		super(candidate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("candidateId", getCandidateId());
		attributes.put("name", getName());
		attributes.put("company", getCompany());
		attributes.put("passed", isPassed());
		attributes.put("points", getPoints());
		attributes.put("testDate", getTestDate());
		attributes.put("location", getLocation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		Boolean passed = (Boolean)attributes.get("passed");

		if (passed != null) {
			setPassed(passed);
		}

		Integer points = (Integer)attributes.get("points");

		if (points != null) {
			setPoints(points);
		}

		Date testDate = (Date)attributes.get("testDate");

		if (testDate != null) {
			setTestDate(testDate);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}
	}

	/**
	 * Returns the candidate ID of this candidate.
	 *
	 * @return the candidate ID of this candidate
	 */
	@Override
	public long getCandidateId() {
		return model.getCandidateId();
	}

	/**
	 * Returns the company of this candidate.
	 *
	 * @return the company of this candidate
	 */
	@Override
	public String getCompany() {
		return model.getCompany();
	}

	/**
	 * Returns the location of this candidate.
	 *
	 * @return the location of this candidate
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the name of this candidate.
	 *
	 * @return the name of this candidate
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the passed of this candidate.
	 *
	 * @return the passed of this candidate
	 */
	@Override
	public boolean getPassed() {
		return model.getPassed();
	}

	/**
	 * Returns the points of this candidate.
	 *
	 * @return the points of this candidate
	 */
	@Override
	public int getPoints() {
		return model.getPoints();
	}

	/**
	 * Returns the primary key of this candidate.
	 *
	 * @return the primary key of this candidate
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the test date of this candidate.
	 *
	 * @return the test date of this candidate
	 */
	@Override
	public Date getTestDate() {
		return model.getTestDate();
	}

	/**
	 * Returns the uuid of this candidate.
	 *
	 * @return the uuid of this candidate
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this candidate is passed.
	 *
	 * @return <code>true</code> if this candidate is passed; <code>false</code> otherwise
	 */
	@Override
	public boolean isPassed() {
		return model.isPassed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the candidate ID of this candidate.
	 *
	 * @param candidateId the candidate ID of this candidate
	 */
	@Override
	public void setCandidateId(long candidateId) {
		model.setCandidateId(candidateId);
	}

	/**
	 * Sets the company of this candidate.
	 *
	 * @param company the company of this candidate
	 */
	@Override
	public void setCompany(String company) {
		model.setCompany(company);
	}

	/**
	 * Sets the location of this candidate.
	 *
	 * @param location the location of this candidate
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the name of this candidate.
	 *
	 * @param name the name of this candidate
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets whether this candidate is passed.
	 *
	 * @param passed the passed of this candidate
	 */
	@Override
	public void setPassed(boolean passed) {
		model.setPassed(passed);
	}

	/**
	 * Sets the points of this candidate.
	 *
	 * @param points the points of this candidate
	 */
	@Override
	public void setPoints(int points) {
		model.setPoints(points);
	}

	/**
	 * Sets the primary key of this candidate.
	 *
	 * @param primaryKey the primary key of this candidate
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the test date of this candidate.
	 *
	 * @param testDate the test date of this candidate
	 */
	@Override
	public void setTestDate(Date testDate) {
		model.setTestDate(testDate);
	}

	/**
	 * Sets the uuid of this candidate.
	 *
	 * @param uuid the uuid of this candidate
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected CandidateWrapper wrap(Candidate candidate) {
		return new CandidateWrapper(candidate);
	}

}