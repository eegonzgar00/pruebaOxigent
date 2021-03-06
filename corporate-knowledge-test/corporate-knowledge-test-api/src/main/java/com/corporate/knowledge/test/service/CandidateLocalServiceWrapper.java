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
 * Provides a wrapper for {@link CandidateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CandidateLocalService
 * @generated
 */
@ProviderType
public class CandidateLocalServiceWrapper
	implements CandidateLocalService, ServiceWrapper<CandidateLocalService> {

	public CandidateLocalServiceWrapper(
		CandidateLocalService candidateLocalService) {

		_candidateLocalService = candidateLocalService;
	}

	/**
	 * Adds the candidate to the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidate the candidate
	 * @return the candidate that was added
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate addCandidate(
		com.corporate.knowledge.test.model.Candidate candidate) {

		return _candidateLocalService.addCandidate(candidate);
	}

	@Override
	public void crearCandidato(String company, String name) {
		_candidateLocalService.crearCandidato(company, name);
	}

	/**
	 * Creates a new candidate with the primary key. Does not add the candidate to the database.
	 *
	 * @param candidateId the primary key for the new candidate
	 * @return the new candidate
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate createCandidate(
		long candidateId) {

		return _candidateLocalService.createCandidate(candidateId);
	}

	/**
	 * Deletes the candidate from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidate the candidate
	 * @return the candidate that was removed
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate deleteCandidate(
		com.corporate.knowledge.test.model.Candidate candidate) {

		return _candidateLocalService.deleteCandidate(candidate);
	}

	/**
	 * Deletes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate that was removed
	 * @throws PortalException if a candidate with the primary key could not be found
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate deleteCandidate(
			long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateLocalService.deleteCandidate(candidateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateLocalService.dynamicQuery();
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

		return _candidateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.CandidateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _candidateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.CandidateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _candidateLocalService.dynamicQuery(
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

		return _candidateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _candidateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.corporate.knowledge.test.model.Candidate fetchCandidate(
		long candidateId) {

		return _candidateLocalService.fetchCandidate(candidateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _candidateLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.corporate.knowledge.test.model.Candidate>
		getAllCandidatesOrdered() {

		return _candidateLocalService.getAllCandidatesOrdered();
	}

	/**
	 * Returns the candidate with the primary key.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate
	 * @throws PortalException if a candidate with the primary key could not be found
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate getCandidate(
			long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateLocalService.getCandidate(candidateId);
	}

	/**
	 * Returns a range of all the candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.corporate.knowledge.test.model.impl.CandidateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of candidates
	 */
	@Override
	public java.util.List<com.corporate.knowledge.test.model.Candidate>
		getCandidates(int start, int end) {

		return _candidateLocalService.getCandidates(start, end);
	}

	/**
	 * Returns the number of candidates.
	 *
	 * @return the number of candidates
	 */
	@Override
	public int getCandidatesCount() {
		return _candidateLocalService.getCandidatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _candidateLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _candidateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _candidateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param candidate the candidate
	 * @return the candidate that was updated
	 */
	@Override
	public com.corporate.knowledge.test.model.Candidate updateCandidate(
		com.corporate.knowledge.test.model.Candidate candidate) {

		return _candidateLocalService.updateCandidate(candidate);
	}

	@Override
	public boolean updateCandidateById(long candidateId, String name) {
		return _candidateLocalService.updateCandidateById(candidateId, name);
	}

	@Override
	public CandidateLocalService getWrappedService() {
		return _candidateLocalService;
	}

	@Override
	public void setWrappedService(CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	private CandidateLocalService _candidateLocalService;

}