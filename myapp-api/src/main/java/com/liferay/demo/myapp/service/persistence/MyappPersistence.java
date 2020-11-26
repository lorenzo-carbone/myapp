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

import com.liferay.demo.myapp.exception.NoSuchMyappException;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the myapp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyappUtil
 * @generated
 */
@ProviderType
public interface MyappPersistence extends BasePersistence<Myapp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MyappUtil} to access the myapp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the myapps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching myapps
	 */
	public java.util.List<Myapp> findByGroupId(long groupId);

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
	public java.util.List<Myapp> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Myapp> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

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
	public java.util.List<Myapp> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public Myapp findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Returns the first myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public Myapp fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

	/**
	 * Returns the last myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public Myapp findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Returns the last myapp in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public Myapp fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

	/**
	 * Returns the myapps before and after the current myapp in the ordered set where groupId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public Myapp[] findByGroupId_PrevAndNext(
			long myappId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Returns all the myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching myapps that the user has permission to view
	 */
	public java.util.List<Myapp> filterFindByGroupId(long groupId);

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
	public java.util.List<Myapp> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Myapp> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

	/**
	 * Returns the myapps before and after the current myapp in the ordered set of myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public Myapp[] filterFindByGroupId_PrevAndNext(
			long myappId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Removes all the myapps where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of myapps where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching myapps
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of myapps that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching myapps that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns all the myapps where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching myapps
	 */
	public java.util.List<Myapp> findByUserId(long userId);

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
	public java.util.List<Myapp> findByUserId(long userId, int start, int end);

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
	public java.util.List<Myapp> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

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
	public java.util.List<Myapp> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public Myapp findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Returns the first myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public Myapp fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

	/**
	 * Returns the last myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp
	 * @throws NoSuchMyappException if a matching myapp could not be found
	 */
	public Myapp findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Returns the last myapp in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching myapp, or <code>null</code> if a matching myapp could not be found
	 */
	public Myapp fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

	/**
	 * Returns the myapps before and after the current myapp in the ordered set where userId = &#63;.
	 *
	 * @param myappId the primary key of the current myapp
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public Myapp[] findByUserId_PrevAndNext(
			long myappId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<Myapp>
				orderByComparator)
		throws NoSuchMyappException;

	/**
	 * Removes all the myapps where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of myapps where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching myapps
	 */
	public int countByUserId(long userId);

	/**
	 * Caches the myapp in the entity cache if it is enabled.
	 *
	 * @param myapp the myapp
	 */
	public void cacheResult(Myapp myapp);

	/**
	 * Caches the myapps in the entity cache if it is enabled.
	 *
	 * @param myapps the myapps
	 */
	public void cacheResult(java.util.List<Myapp> myapps);

	/**
	 * Creates a new myapp with the primary key. Does not add the myapp to the database.
	 *
	 * @param myappId the primary key for the new myapp
	 * @return the new myapp
	 */
	public Myapp create(long myappId);

	/**
	 * Removes the myapp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp that was removed
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public Myapp remove(long myappId) throws NoSuchMyappException;

	public Myapp updateImpl(Myapp myapp);

	/**
	 * Returns the myapp with the primary key or throws a <code>NoSuchMyappException</code> if it could not be found.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp
	 * @throws NoSuchMyappException if a myapp with the primary key could not be found
	 */
	public Myapp findByPrimaryKey(long myappId) throws NoSuchMyappException;

	/**
	 * Returns the myapp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param myappId the primary key of the myapp
	 * @return the myapp, or <code>null</code> if a myapp with the primary key could not be found
	 */
	public Myapp fetchByPrimaryKey(long myappId);

	/**
	 * Returns all the myapps.
	 *
	 * @return the myapps
	 */
	public java.util.List<Myapp> findAll();

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
	public java.util.List<Myapp> findAll(int start, int end);

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
	public java.util.List<Myapp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator);

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
	public java.util.List<Myapp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Myapp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the myapps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of myapps.
	 *
	 * @return the number of myapps
	 */
	public int countAll();

}