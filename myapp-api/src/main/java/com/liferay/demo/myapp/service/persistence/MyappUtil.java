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

package com.liferay.demo.myapp.service.persistence;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the myapp service. This utility wraps <code>com.liferay.demo.myapp.service.persistence.impl.MyappPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyappPersistence
 * @generated
 */
public class MyappUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Myapp myapp) {
		getPersistence().clearCache(myapp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Myapp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Myapp> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Myapp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Myapp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Myapp update(Myapp myapp) {
		return getPersistence().update(myapp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Myapp update(Myapp myapp, ServiceContext serviceContext) {
		return getPersistence().update(myapp, serviceContext);
	}

	/**
	 * Returns all the myapps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching myapps
	 */
	public static List<Myapp> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the myapps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @return the range of matching myapps
	 */
	public static List<Myapp> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the myapps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching myapps
	 */
	public static List<Myapp> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the myapps where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching myapps
	 */
	public static List<Myapp> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Myapp> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public static Myapp findByGroupId_First(
			long groupId, OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public static Myapp fetchByGroupId_First(
		long groupId, OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public static Myapp findByGroupId_Last(
			long groupId, OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public static Myapp fetchByGroupId_Last(
		long groupId, OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the myapps before and after the current myapp in the ordered set where groupId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public static Myapp[] findByGroupId_PrevAndNext(
			long myappId, long groupId,
			OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByGroupId_PrevAndNext(
			myappId, groupId, orderByComparator);
	}

	/**
	 * Returns all the myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching myapps that the user has permission to view
	 */
	public static List<Myapp> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the myapps that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @return the range of matching myapps that the user has permission to view
	 */
	public static List<Myapp> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the myapps that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching myapps that the user has permission to view
	 */
	public static List<Myapp> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the myapps before and after the current myapp in the ordered set of myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public static Myapp[] filterFindByGroupId_PrevAndNext(
			long myappId, long groupId,
			OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			myappId, groupId, orderByComparator);
	}

	/**
	 * Removes all the myapps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of myapps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching myapps
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching myapps that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns all the myapps where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching myapps
	 */
	public static List<Myapp> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the myapps where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @return the range of matching myapps
	 */
	public static List<Myapp> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the myapps where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching myapps
	 */
	public static List<Myapp> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the myapps where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching myapps
	 */
	public static List<Myapp> findByUserId(
		long userId, int start, int end,
		OrderByComparator<Myapp> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public static Myapp findByUserId_First(
			long userId, OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public static Myapp fetchByUserId_First(
		long userId, OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public static Myapp findByUserId_Last(
			long userId, OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public static Myapp fetchByUserId_Last(
		long userId, OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the myapps before and after the current myapp in the ordered set where userId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public static Myapp[] findByUserId_PrevAndNext(
			long myappId, long userId,
			OrderByComparator<Myapp> orderByComparator)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByUserId_PrevAndNext(
			myappId, userId, orderByComparator);
	}

	/**
	 * Removes all the myapps where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of myapps where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching myapps
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Caches the myapp in the entity cache if it is enabled.
	 *
	 * @param myapp the myapp
	 */
	public static void cacheResult(Myapp myapp) {
		getPersistence().cacheResult(myapp);
	}

	/**
	 * Caches the myapps in the entity cache if it is enabled.
	 *
	 * @param myapps the myapps
	 */
	public static void cacheResult(List<Myapp> myapps) {
		getPersistence().cacheResult(myapps);
	}

	/**
	 * Creates a new myapp with the primary key. Does not add the myapp to the database.
	 *
	 * @param myappId the primary key for the new myapp
	 * @return the new myapp
	 */
	public static Myapp create(long myappId) {
		return getPersistence().create(myappId);
	}

	/**
	 * Removes the myapp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp that was removed
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public static Myapp remove(long myappId)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().remove(myappId);
	}

	public static Myapp updateImpl(Myapp myapp) {
		return getPersistence().updateImpl(myapp);
	}

	/**
	 * Returns the myapp with the primary key or throws a <code>NoSuchMyappException</code> if it could not be found.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public static Myapp findByPrimaryKey(long myappId)
		throws com.liferay.demo.myapp.exception.NoSuchMyappException {

		return getPersistence().findByPrimaryKey(myappId);
	}

	/**
	 * Returns the myapp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp, or <code>null</code> if a myapp with the primary key could not be found
	 */
	public static Myapp fetchByPrimaryKey(long myappId) {
		return getPersistence().fetchByPrimaryKey(myappId);
	}

	/**
	 * Returns all the myapps.
	 *
	 * @return the myapps
	 */
	public static List<Myapp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the myapps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @return the range of myapps
	 */
	public static List<Myapp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the myapps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of myapps
	 */
	public static List<Myapp> findAll(
		int start, int end, OrderByComparator<Myapp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the myapps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyappModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of myapps
	 * @param end the upper bound of the range of myapps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of myapps
	 */
	public static List<Myapp> findAll(
		int start, int end, OrderByComparator<Myapp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the myapps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of myapps.
	 *
	 * @return the number of myapps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MyappPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MyappPersistence, MyappPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MyappPersistence.class);

		ServiceTracker<MyappPersistence, MyappPersistence> serviceTracker =
			new ServiceTracker<MyappPersistence, MyappPersistence>(
				bundle.getBundleContext(), MyappPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}