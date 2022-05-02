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

import com.corporate.knowledge.test.exception.NoSuchCandidateException;
import com.corporate.knowledge.test.model.Candidate;
import com.corporate.knowledge.test.service.CandidateLocalServiceUtil;
import com.corporate.knowledge.test.service.persistence.CandidatePersistence;
import com.corporate.knowledge.test.service.persistence.CandidateUtil;

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
public class CandidatePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.corporate.knowledge.test.service"));

	@Before
	public void setUp() {
		_persistence = CandidateUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Candidate> iterator = _candidates.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Candidate candidate = _persistence.create(pk);

		Assert.assertNotNull(candidate);

		Assert.assertEquals(candidate.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Candidate newCandidate = addCandidate();

		_persistence.remove(newCandidate);

		Candidate existingCandidate = _persistence.fetchByPrimaryKey(
			newCandidate.getPrimaryKey());

		Assert.assertNull(existingCandidate);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCandidate();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Candidate newCandidate = _persistence.create(pk);

		newCandidate.setUuid(RandomTestUtil.randomString());

		newCandidate.setName(RandomTestUtil.randomString());

		newCandidate.setCompany(RandomTestUtil.randomString());

		newCandidate.setPassed(RandomTestUtil.randomBoolean());

		newCandidate.setPoints(RandomTestUtil.nextInt());

		newCandidate.setTestDate(RandomTestUtil.nextDate());

		newCandidate.setLocation(RandomTestUtil.randomString());

		_candidates.add(_persistence.update(newCandidate));

		Candidate existingCandidate = _persistence.findByPrimaryKey(
			newCandidate.getPrimaryKey());

		Assert.assertEquals(
			existingCandidate.getUuid(), newCandidate.getUuid());
		Assert.assertEquals(
			existingCandidate.getCandidateId(), newCandidate.getCandidateId());
		Assert.assertEquals(
			existingCandidate.getName(), newCandidate.getName());
		Assert.assertEquals(
			existingCandidate.getCompany(), newCandidate.getCompany());
		Assert.assertEquals(
			existingCandidate.isPassed(), newCandidate.isPassed());
		Assert.assertEquals(
			existingCandidate.getPoints(), newCandidate.getPoints());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCandidate.getTestDate()),
			Time.getShortTimestamp(newCandidate.getTestDate()));
		Assert.assertEquals(
			existingCandidate.getLocation(), newCandidate.getLocation());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Candidate newCandidate = addCandidate();

		Candidate existingCandidate = _persistence.findByPrimaryKey(
			newCandidate.getPrimaryKey());

		Assert.assertEquals(existingCandidate, newCandidate);
	}

	@Test(expected = NoSuchCandidateException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Candidate> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"knowledgeTest_Candidate", "uuid", true, "candidateId", true,
			"name", true, "company", true, "passed", true, "points", true,
			"testDate", true, "location", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Candidate newCandidate = addCandidate();

		Candidate existingCandidate = _persistence.fetchByPrimaryKey(
			newCandidate.getPrimaryKey());

		Assert.assertEquals(existingCandidate, newCandidate);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Candidate missingCandidate = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCandidate);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Candidate newCandidate1 = addCandidate();
		Candidate newCandidate2 = addCandidate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidate1.getPrimaryKey());
		primaryKeys.add(newCandidate2.getPrimaryKey());

		Map<Serializable, Candidate> candidates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, candidates.size());
		Assert.assertEquals(
			newCandidate1, candidates.get(newCandidate1.getPrimaryKey()));
		Assert.assertEquals(
			newCandidate2, candidates.get(newCandidate2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Candidate> candidates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Candidate newCandidate = addCandidate();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidate.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Candidate> candidates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidates.size());
		Assert.assertEquals(
			newCandidate, candidates.get(newCandidate.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Candidate> candidates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(candidates.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Candidate newCandidate = addCandidate();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCandidate.getPrimaryKey());

		Map<Serializable, Candidate> candidates =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, candidates.size());
		Assert.assertEquals(
			newCandidate, candidates.get(newCandidate.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CandidateLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Candidate>() {

				@Override
				public void performAction(Candidate candidate) {
					Assert.assertNotNull(candidate);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Candidate newCandidate = addCandidate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Candidate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"candidateId", newCandidate.getCandidateId()));

		List<Candidate> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Candidate existingCandidate = result.get(0);

		Assert.assertEquals(existingCandidate, newCandidate);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Candidate.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"candidateId", RandomTestUtil.nextLong()));

		List<Candidate> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Candidate newCandidate = addCandidate();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Candidate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("candidateId"));

		Object newCandidateId = newCandidate.getCandidateId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"candidateId", new Object[] {newCandidateId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCandidateId = result.get(0);

		Assert.assertEquals(existingCandidateId, newCandidateId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Candidate.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("candidateId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"candidateId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Candidate addCandidate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Candidate candidate = _persistence.create(pk);

		candidate.setUuid(RandomTestUtil.randomString());

		candidate.setName(RandomTestUtil.randomString());

		candidate.setCompany(RandomTestUtil.randomString());

		candidate.setPassed(RandomTestUtil.randomBoolean());

		candidate.setPoints(RandomTestUtil.nextInt());

		candidate.setTestDate(RandomTestUtil.nextDate());

		candidate.setLocation(RandomTestUtil.randomString());

		_candidates.add(_persistence.update(candidate));

		return candidate;
	}

	private List<Candidate> _candidates = new ArrayList<Candidate>();
	private CandidatePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}