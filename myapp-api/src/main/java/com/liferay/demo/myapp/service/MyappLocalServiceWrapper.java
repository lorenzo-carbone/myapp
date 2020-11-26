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

package com.liferay.demo.myapp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MyappLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyappLocalService
 * @generated
 */
public class MyappLocalServiceWrapper
	implements MyappLocalService, ServiceWrapper<MyappLocalService> {

	public MyappLocalServiceWrapper(MyappLocalService myappLocalService) {
		_myappLocalService = myappLocalService;
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp addMyApp(
			long groupId, long articleId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.addMyApp(
			groupId, articleId, title, description, serviceContext);
	}

	/**
	 * Adds the myapp to the database. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was added
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp addMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return _myappLocalService.addMyapp(myapp);
	}

	/**
	 * Creates a new myapp with the primary key. Does not add the myapp to the database.
	 *
	 * @param myappId the primary key for the new myapp
	 * @return the new myapp
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp createMyapp(long myappId) {
		return _myappLocalService.createMyapp(myappId);
	}

	/**
	 * Deletes the myapp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp that was removed
	 * @throws PortalException if a myapp with the primary key could not be found
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp deleteMyapp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.deleteMyapp(myappId);
	}

	/**
	 * Deletes the myapp from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was removed
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp deleteMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return _myappLocalService.deleteMyapp(myapp);
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp deleteMyApp(
			com.liferay.demo.myapp.model.Myapp myApp)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.deleteMyApp(myApp);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myappLocalService.dynamicQuery();
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

		return _myappLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.demo.myapp.model.impl.MyappModelImpl</code>.
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

		return _myappLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.demo.myapp.model.impl.MyappModelImpl</code>.
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

		return _myappLocalService.dynamicQuery(
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

		return _myappLocalService.dynamicQueryCount(dynamicQuery);
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

		return _myappLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp fetchMyapp(long myappId) {
		return _myappLocalService.fetchMyapp(myappId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _myappLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _myappLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the myapp with the primary key.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp
	 * @throws PortalException if a myapp with the primary key could not be found
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp getMyapp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.getMyapp(myappId);
	}

	/**
	 * Returns a range of all the myapps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.demo.myapp.model.impl.MyappModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @return the range of myapps
	 */
	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp> getMyapps(
		int start, int end) {

		return _myappLocalService.getMyapps(start, end);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId) {

		return _myappLocalService.getMyAppsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId, int start, int end) {

		return _myappLocalService.getMyAppsByGroupId(groupId, start, end);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator) {

		return _myappLocalService.getMyAppsByGroupId(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator) {

		return _myappLocalService.getMyAppsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp> getMyAppsByUserId(
		long userId) {

		return _myappLocalService.getMyAppsByUserId(userId);
	}

	/**
	 * Returns the number of myapps.
	 *
	 * @return the number of myapps
	 */
	@Override
	public int getMyappsCount() {
		return _myappLocalService.getMyappsCount();
	}

	@Override
	public long getMyAppsCountByKeywords(long groupId, String keywords) {
		return _myappLocalService.getMyAppsCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _myappLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp updateMyApp(
			long myAppId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappLocalService.updateMyApp(
			myAppId, title, description, serviceContext);
	}

	/**
	 * Updates the myapp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was updated
	 */
	@Override
	public com.liferay.demo.myapp.model.Myapp updateMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return _myappLocalService.updateMyapp(myapp);
	}

	@Override
	public MyappLocalService getWrappedService() {
		return _myappLocalService;
	}

	@Override
	public void setWrappedService(MyappLocalService myappLocalService) {
		_myappLocalService = myappLocalService;
	}

	private MyappLocalService _myappLocalService;

}