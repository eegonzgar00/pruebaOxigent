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

package com.corporate.knowledge.test.service.persistence.test;

import com.corporate.knowledge.test.exception.NoSuchProductoException;
import com.corporate.knowledge.test.model.Producto;
import com.corporate.knowledge.test.service.ProductoLocalServiceUtil;
import com.corporate.knowledge.test.service.persistence.ProductoPersistence;
import com.corporate.knowledge.test.service.persistence.ProductoUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ProductoPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.corporate.knowledge.test.service"));

	@Before
	public void setUp() {
		_persistence = ProductoUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Producto> iterator = _productos.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Producto producto = _persistence.create(pk);

		Assert.assertNotNull(producto);

		Assert.assertEquals(producto.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Producto newProducto = addProducto();

		_persistence.remove(newProducto);

		Producto existingProducto = _persistence.fetchByPrimaryKey(
			newProducto.getPrimaryKey());

		Assert.assertNull(existingProducto);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addProducto();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Producto newProducto = _persistence.create(pk);

		newProducto.setUuid(RandomTestUtil.randomString());

		newProducto.setName(RandomTestUtil.randomString());

		newProducto.setCreationDate(RandomTestUtil.nextDate());

		_productos.add(_persistence.update(newProducto));

		Producto existingProducto = _persistence.findByPrimaryKey(
			newProducto.getPrimaryKey());

		Assert.assertEquals(existingProducto.getUuid(), newProducto.getUuid());
		Assert.assertEquals(
			existingProducto.getProductId(), newProducto.getProductId());
		Assert.assertEquals(existingProducto.getName(), newProducto.getName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingProducto.getCreationDate()),
			Time.getShortTimestamp(newProducto.getCreationDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Producto newProducto = addProducto();

		Producto existingProducto = _persistence.findByPrimaryKey(
			newProducto.getPrimaryKey());

		Assert.assertEquals(existingProducto, newProducto);
	}

	@Test(expected = NoSuchProductoException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Producto> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"knowledgeTest_Producto", "uuid", true, "productId", true, "name",
			true, "creationDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Producto newProducto = addProducto();

		Producto existingProducto = _persistence.fetchByPrimaryKey(
			newProducto.getPrimaryKey());

		Assert.assertEquals(existingProducto, newProducto);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Producto missingProducto = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingProducto);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Producto newProducto1 = addProducto();
		Producto newProducto2 = addProducto();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProducto1.getPrimaryKey());
		primaryKeys.add(newProducto2.getPrimaryKey());

		Map<Serializable, Producto> productos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, productos.size());
		Assert.assertEquals(
			newProducto1, productos.get(newProducto1.getPrimaryKey()));
		Assert.assertEquals(
			newProducto2, productos.get(newProducto2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Producto> productos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(productos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Producto newProducto = addProducto();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProducto.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Producto> productos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, productos.size());
		Assert.assertEquals(
			newProducto, productos.get(newProducto.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Producto> productos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(productos.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Producto newProducto = addProducto();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newProducto.getPrimaryKey());

		Map<Serializable, Producto> productos = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, productos.size());
		Assert.assertEquals(
			newProducto, productos.get(newProducto.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ProductoLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Producto>() {

				@Override
				public void performAction(Producto producto) {
					Assert.assertNotNull(producto);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Producto newProducto = addProducto();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Producto.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"productId", newProducto.getProductId()));

		List<Producto> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Producto existingProducto = result.get(0);

		Assert.assertEquals(existingProducto, newProducto);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Producto.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("productId", RandomTestUtil.nextLong()));

		List<Producto> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Producto newProducto = addProducto();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Producto.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		Object newProductId = newProducto.getProductId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {newProductId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingProductId = result.get(0);

		Assert.assertEquals(existingProductId, newProductId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Producto.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("productId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"productId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Producto addProducto() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Producto producto = _persistence.create(pk);

		producto.setUuid(RandomTestUtil.randomString());

		producto.setName(RandomTestUtil.randomString());

		producto.setCreationDate(RandomTestUtil.nextDate());

		_productos.add(_persistence.update(producto));

		return producto;
	}

	private List<Producto> _productos = new ArrayList<Producto>();
	private ProductoPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}