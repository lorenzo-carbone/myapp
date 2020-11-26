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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Myapp. This utility wraps
 * <code>com.liferay.demo.myapp.service.impl.MyappLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MyappLocalService
 * @generated
 */
public class MyappLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.demo.myapp.service.impl.MyappLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.demo.myapp.model.Myapp addMyApp(
			long groupId, long articleId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMyApp(
			groupId, articleId, title, description, serviceContext);
	}

	/**
	 * Adds the myapp to the database. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was added
	 */
	public static com.liferay.demo.myapp.model.Myapp addMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return getService().addMyapp(myapp);
	}

	/**
	 * Creates a new myapp with the primary key. Does not add the myapp to the database.
	 *
	 * @param myappId the primary key for the new myapp
	 * @return the new myapp
	 */
	public static com.liferay.demo.myapp.model.Myapp createMyapp(long myappId) {
		return getService().createMyapp(myappId);
	}

	/**
	 * Deletes the myapp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp that was removed
	 * @throws PortalException if a myapp with the primary key could not be found
	 */
	public static com.liferay.demo.myapp.model.Myapp deleteMyapp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMyapp(myappId);
	}

	/**
	 * Deletes the myapp from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was removed
	 */
	public static com.liferay.demo.myapp.model.Myapp deleteMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return getService().deleteMyapp(myapp);
	}

	public static com.liferay.demo.myapp.model.Myapp deleteMyApp(
			com.liferay.demo.myapp.model.Myapp myApp)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMyApp(myApp);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.demo.myapp.model.Myapp fetchMyapp(long myappId) {
		return getService().fetchMyapp(myappId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the myapp with the primary key.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp
	 * @throws PortalException if a myapp with the primary key could not be found
	 */
	public static com.liferay.demo.myapp.model.Myapp getMyapp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMyapp(myappId);
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
	public static java.util.List<com.liferay.demo.myapp.model.Myapp> getMyapps(
		int start, int end) {

		return getService().getMyapps(start, end);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId) {

		return getService().getMyAppsByGroupId(groupId);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId, int start, int end) {

		return getService().getMyAppsByGroupId(groupId, start, end);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator) {

		return getService().getMyAppsByGroupId(
			groupId, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator) {

		return getService().getMyAppsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByUserId(long userId) {

		return getService().getMyAppsByUserId(userId);
	}

	/**
	 * Returns the number of myapps.
	 *
	 * @return the number of myapps
	 */
	public static int getMyappsCount() {
		return getService().getMyappsCount();
	}

	public static long getMyAppsCountByKeywords(long groupId, String keywords) {
		return getService().getMyAppsCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.demo.myapp.model.Myapp updateMyApp(
			long myAppId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMyApp(
			myAppId, title, description, serviceContext);
	}

	/**
	 * Updates the myapp in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param myapp the myapp
	 * @return the myapp that was updated
	 */
	public static com.liferay.demo.myapp.model.Myapp updateMyapp(
		com.liferay.demo.myapp.model.Myapp myapp) {

		return getService().updateMyapp(myapp);
	}

	public static MyappLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MyappLocalService, MyappLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MyappLocalService.class);

		ServiceTracker<MyappLocalService, MyappLocalService> serviceTracker =
			new ServiceTracker<MyappLocalService, MyappLocalService>(
				bundle.getBundleContext(), MyappLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}