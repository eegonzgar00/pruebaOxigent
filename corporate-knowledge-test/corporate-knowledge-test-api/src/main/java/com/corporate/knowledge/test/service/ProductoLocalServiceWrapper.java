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

package com.corporate.knowledge.test.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link ProductoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProductoLocalService
 * @generated
 */
@ProviderType
public class ProductoLocalServiceWrapper
	implements ProductoLocalService, ServiceWrapper<ProductoLocalService> {

	public ProductoLocalServiceWrapper(
		ProductoLocalService productoLocalService) {

		_productoLocalService = productoLocalService;
	}

	/**
	 * Adds the producto to the database. Also notifies the appropriate model listeners.
	 *
	 * @param producto the producto
	 * @return the producto that was added
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto addProducto(
		com.corporate.knowledge.test.model.Producto producto) {

		return _productoLocalService.addProducto(producto);
	}

	/**
	 * Creates a new producto with the primary key. Does not add the producto to the database.
	 *
	 * @param productId the primary key for the new producto
	 * @return the new producto
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto createProducto(
		long productId) {

		return _productoLocalService.createProducto(productId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the producto with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the producto
	 * @return the producto that was removed
	 * @throws PortalException if a producto with the primary key could not be found
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto deleteProducto(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoLocalService.deleteProducto(productId);
	}

	/**
	 * Deletes the producto from the database. Also notifies the appropriate model listeners.
	 *
	 * @param producto the producto
	 * @return the producto that was removed
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto deleteProducto(
		com.corporate.knowledge.test.model.Producto producto) {

		return _productoLocalService.deleteProducto(producto);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productoLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.ProductoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.ProductoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productoLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productoLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.corporate.knowledge.test.model.Producto fetchProducto(
		long productId) {

		return _productoLocalService.fetchProducto(productId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productoLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the producto with the primary key.
	 *
	 * @param productId the primary key of the producto
	 * @return the producto
	 * @throws PortalException if a producto with the primary key could not be found
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto getProducto(
			long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productoLocalService.getProducto(productId);
	}

	/**
	 * Returns a range of all the productos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.ProductoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of productos
	 * @param end the upper bound of the range of productos (not inclusive)
	 * @return the range of productos
	 */
	@Override
	public java.util.List<com.corporate.knowledge.test.model.Producto>
		getProductos(int start, int end) {

		return _productoLocalService.getProductos(start, end);
	}

	/**
	 * Returns the number of productos.
	 *
	 * @return the number of productos
	 */
	@Override
	public int getProductosCount() {
		return _productoLocalService.getProductosCount();
	}

	/**
	 * Updates the producto in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param producto the producto
	 * @return the producto that was updated
	 */
	@Override
	public com.corporate.knowledge.test.model.Producto updateProducto(
		com.corporate.knowledge.test.model.Producto producto) {

		return _productoLocalService.updateProducto(producto);
	}

	@Override
	public ProductoLocalService getWrappedService() {
		return _productoLocalService;
	}

	@Override
	public void setWrappedService(ProductoLocalService productoLocalService) {
		_productoLocalService = productoLocalService;
	}

	private ProductoLocalService _productoLocalService;

}