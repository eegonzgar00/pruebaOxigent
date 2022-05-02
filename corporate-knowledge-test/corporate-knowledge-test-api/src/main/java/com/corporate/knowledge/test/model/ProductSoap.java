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
 * This class is used by SOAP remote services, specifically {@link com.corporate.knowledge.test.service.http.ProductServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ProductSoap implements Serializable {

	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProductId(model.getProductId());
		soapModel.setName(model.getName());
		soapModel.setCreationDate(model.getCreationDate());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(
			models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
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