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

import com.corporate.knowledge.test.model.Producto;

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
 * The cache model class for representing Producto in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProductoCacheModel
	implements CacheModel<Producto>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductoCacheModel)) {
			return false;
		}

		ProductoCacheModel productoCacheModel = (ProductoCacheModel)obj;

		if (productId == productoCacheModel.productId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, productId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", productId=");
		sb.append(productId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", creationDate=");
		sb.append(creationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Producto toEntityModel() {
		ProductoImpl productoImpl = new ProductoImpl();

		if (uuid == null) {
			productoImpl.setUuid("");
		}
		else {
			productoImpl.setUuid(uuid);
		}

		productoImpl.setProductId(productId);

		if (name == null) {
			productoImpl.setName("");
		}
		else {
			productoImpl.setName(name);
		}

		if (creationDate == Long.MIN_VALUE) {
			productoImpl.setCreationDate(null);
		}
		else {
			productoImpl.setCreationDate(new Date(creationDate));
		}

		productoImpl.resetOriginalValues();

		return productoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		productId = objectInput.readLong();
		name = objectInput.readUTF();
		creationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(productId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(creationDate);
	}

	public String uuid;
	public long productId;
	public String name;
	public long creationDate;

}