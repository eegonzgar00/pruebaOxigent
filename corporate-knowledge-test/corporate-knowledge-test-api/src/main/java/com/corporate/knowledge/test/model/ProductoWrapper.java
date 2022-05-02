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
 * This class is a wrapper for {@link Producto}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Producto
 * @generated
 */
@ProviderType
public class ProductoWrapper
	extends BaseModelWrapper<Producto>
	implements Producto, ModelWrapper<Producto> {

	public ProductoWrapper(Producto producto) {
		super(producto);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("productId", getProductId());
		attributes.put("name", getName());
		attributes.put("creationDate", getCreationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long productId = (Long)attributes.get("productId");

		if (productId != null) {
			setProductId(productId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Date creationDate = (Date)attributes.get("creationDate");

		if (creationDate != null) {
			setCreationDate(creationDate);
		}
	}

	/**
	 * Returns the creation date of this producto.
	 *
	 * @return the creation date of this producto
	 */
	@Override
	public Date getCreationDate() {
		return model.getCreationDate();
	}

	/**
	 * Returns the name of this producto.
	 *
	 * @return the name of this producto
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this producto.
	 *
	 * @return the primary key of this producto
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product ID of this producto.
	 *
	 * @return the product ID of this producto
	 */
	@Override
	public long getProductId() {
		return model.getProductId();
	}

	/**
	 * Returns the uuid of this producto.
	 *
	 * @return the uuid of this producto
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the creation date of this producto.
	 *
	 * @param creationDate the creation date of this producto
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		model.setCreationDate(creationDate);
	}

	/**
	 * Sets the name of this producto.
	 *
	 * @param name the name of this producto
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this producto.
	 *
	 * @param primaryKey the primary key of this producto
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product ID of this producto.
	 *
	 * @param productId the product ID of this producto
	 */
	@Override
	public void setProductId(long productId) {
		model.setProductId(productId);
	}

	/**
	 * Sets the uuid of this producto.
	 *
	 * @param uuid the uuid of this producto
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected ProductoWrapper wrap(Producto producto) {
		return new ProductoWrapper(producto);
	}

}