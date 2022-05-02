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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Producto service. Represents a row in the &quot;knowledgeTest_Producto&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.corporate.knowledge.test.model.impl.ProductoModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.corporate.knowledge.test.model.impl.ProductoImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Producto
 * @generated
 */
@ProviderType
public interface ProductoModel extends BaseModel<Producto> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a producto model instance should use the {@link Producto} interface instead.
	 */

	/**
	 * Returns the primary key of this producto.
	 *
	 * @return the primary key of this producto
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this producto.
	 *
	 * @param primaryKey the primary key of this producto
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this producto.
	 *
	 * @return the uuid of this producto
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this producto.
	 *
	 * @param uuid the uuid of this producto
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the product ID of this producto.
	 *
	 * @return the product ID of this producto
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this producto.
	 *
	 * @param productId the product ID of this producto
	 */
	public void setProductId(long productId);

	/**
	 * Returns the name of this producto.
	 *
	 * @return the name of this producto
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this producto.
	 *
	 * @param name the name of this producto
	 */
	public void setName(String name);

	/**
	 * Returns the creation date of this producto.
	 *
	 * @return the creation date of this producto
	 */
	public Date getCreationDate();

	/**
	 * Sets the creation date of this producto.
	 *
	 * @param creationDate the creation date of this producto
	 */
	public void setCreationDate(Date creationDate);

}