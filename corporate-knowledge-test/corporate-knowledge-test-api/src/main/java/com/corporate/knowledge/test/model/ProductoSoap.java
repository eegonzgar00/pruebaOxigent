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
 * This class is used by SOAP remote services, specifically {@link com.corporate.knowledge.test.service.http.ProductoServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProductoSoap implements Serializable {

	public static ProductoSoap toSoapModel(Producto model) {
		ProductoSoap soapModel = new ProductoSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProductId(model.getProductId());
		soapModel.setName(model.getName());
		soapModel.setCreationDate(model.getCreationDate());

		return soapModel;
	}

	public static ProductoSoap[] toSoapModels(Producto[] models) {
		ProductoSoap[] soapModels = new ProductoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductoSoap[][] toSoapModels(Producto[][] models) {
		ProductoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductoSoap[] toSoapModels(List<Producto> models) {
		List<ProductoSoap> soapModels = new ArrayList<ProductoSoap>(
			models.size());

		for (Producto model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductoSoap[soapModels.size()]);
	}

	public ProductoSoap() {
	}

	public long getPrimaryKey() {
		return _productId;
	}

	public void setPrimaryKey(long pk) {
		setProductId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public Date getCreationDate() {
		return _creationDate;
	}

	public void setCreationDate(Date creationDate) {
		_creationDate = creationDate;
	}

	private String _uuid;
	private long _productId;
	private String _name;
	private Date _creationDate;

}