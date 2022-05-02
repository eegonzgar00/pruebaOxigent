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

package com.corporate.knowledge.test.model.impl;

import com.corporate.knowledge.test.model.Candidate;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Candidate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CandidateCacheModel
	implements CacheModel<Candidate>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateCacheModel)) {
			return false;
		}

		CandidateCacheModel candidateCacheModel = (CandidateCacheModel)obj;

		if (candidateId == candidateCacheModel.candidateId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, candidateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", company=");
		sb.append(company);
		sb.append(", passed=");
		sb.append(passed);
		sb.append(", points=");
		sb.append(points);
		sb.append(", testDate=");
		sb.append(testDate);
		sb.append(", location=");
		sb.append(location);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Candidate toEntityModel() {
		CandidateImpl candidateImpl = new CandidateImpl();

		if (uuid == null) {
			candidateImpl.setUuid("");
		}
		else {
			candidateImpl.setUuid(uuid);
		}

		candidateImpl.setCandidateId(candidateId);

		if (name == null) {
			candidateImpl.setName("");
		}
		else {
			candidateImpl.setName(name);
		}

		if (company == null) {
			candidateImpl.setCompany("");
		}
		else {
			candidateImpl.setCompany(company);
		}

		candidateImpl.setPassed(passed);
		candidateImpl.setPoints(points);

		if (testDate == Long.MIN_VALUE) {
			candidateImpl.setTestDate(null);
		}
		else {
			candidateImpl.setTestDate(new Date(testDate));
		}

		if (location == null) {
			candidateImpl.setLocation("");
		}
		else {
			candidateImpl.setLocation(location);
		}

		candidateImpl.resetOriginalValues();

		return candidateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		candidateId = objectInput.readLong();
		name = objectInput.readUTF();
		company = objectInput.readUTF();

		passed = objectInput.readBoolean();

		points = objectInput.readInt();
		testDate = objectInput.readLong();
		location = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(candidateId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (company == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(company);
		}

		objectOutput.writeBoolean(passed);

		objectOutput.writeInt(points);
		objectOutput.writeLong(testDate);

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}
	}

	public String uuid;
	public long candidateId;
	public String name;
	public String company;
	public boolean passed;
	public int points;
	public long testDate;
	public String location;

}