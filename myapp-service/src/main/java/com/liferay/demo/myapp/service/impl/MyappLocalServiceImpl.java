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

package com.liferay.demo.myapp.service.impl;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.base.MyappLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the myapp local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.demo.myapp.service.MyappLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyappLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.liferay.demo.myapp.model.Myapp", service = AopService.class)
public class MyappLocalServiceImpl extends MyappLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.liferay.demo.myapp.service.MyappLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.liferay.demo.myapp.service.MyappLocalServiceUtil</code>.
	 */
	@Override
	public Myapp addMyapp(Myapp myApp) {
		throw new UnsupportedOperationException("Not supported.");
	}

	@Override
	public Myapp updateMyapp(Myapp myApp) {
		throw new UnsupportedOperationException("Not supported.");
	}
	
	private void updateAsset(
			Myapp myApp, ServiceContext serviceContext)
	     throws PortalException {

	     assetEntryLocalService.updateEntry(
	         serviceContext.getUserId(), serviceContext.getScopeGroupId(),
	         myApp.getCreateDate(), myApp.getModifiedDate(),
	         Myapp.class.getName(), myApp.getMyappId(),
	         myApp.getUserUuid(), 0, serviceContext.getAssetCategoryIds(),
	         serviceContext.getAssetTagNames(), true, true,
	         myApp.getCreateDate(), null, null, null,
	         ContentTypes.TEXT_HTML,
	         myApp.getTitle(),
	         myApp.getDescription(), null, null, null, 0, 0,
	         serviceContext.getAssetPriority());
	 }

	public Myapp addMyApp(long groupId, long articleId, String title, String description, ServiceContext serviceContext)
			throws PortalException {

		// Get group and user.

		Group group = groupLocalService.getGroup(groupId);

		long userId = serviceContext.getUserId();

		User user = userLocalService.getUser(userId);

		// Generate primary key for the assignment.

		long myAppId = counterLocalService.increment(Myapp.class.getName());

		// Create assigment. This doesn't yet persist the entity.

		Myapp myApp = createMyapp(myAppId);

		// Populate fields.

		myApp.setCompanyId(group.getCompanyId());
		myApp.setCreateDate(serviceContext.getCreateDate(new Date()));
		myApp.setDescription(description);
		myApp.setGroupId(groupId);
		myApp.setArticleId(articleId);
		myApp.setModifiedDate(serviceContext.getModifiedDate(new Date()));
		myApp.setTitle(title);
		myApp.setUserId(userId);
		myApp.setUserName(user.getScreenName());
		
		myApp = super.addMyapp(myApp);

		// Add permission resources.

		boolean portletActions = false;
		boolean addGroupPermissions = true;
		boolean addGuestPermissions = true;

	    resourceLocalService.addResources(
			group.getCompanyId(), groupId, userId, Myapp.class.getName(),
			myApp.getMyappId(), portletActions, addGroupPermissions,
			addGuestPermissions);
	    
	    // Update asset resources.

	    updateAsset(myApp, serviceContext);

		return myApp;
	}

	public Myapp updateMyApp(long myAppId, String title, String description, ServiceContext serviceContext)
			throws PortalException {

		// Get the Assignment by id.

		Myapp myApp = getMyapp(myAppId);

		// Set updated fields and modification date.

		myApp.setModifiedDate(new Date());
		myApp.setTitle(title);
		myApp.setDescription(description);

		myApp = super.updateMyapp(myApp);
		
		// Update asset resources.

	    updateAsset(myApp, serviceContext);

		return myApp;
	}
	
	 public Myapp deleteMyApp(Myapp myApp)
	     throws PortalException {

	     // Delete permission resources.

	     resourceLocalService.deleteResource(
	         myApp, ResourceConstants.SCOPE_INDIVIDUAL);
	     
	     // Delete the Asset resource.

	     assetEntryLocalService.deleteEntry(
	         Myapp.class.getName(),  myApp.getMyappId());

	     // Delete the Assignment

	     return super.deleteMyapp(myApp);
	 }
	
	public List<Myapp> getMyAppsByUserId(long userId) {

		return myappPersistence.findByUserId(userId);
	}

	public List<Myapp> getMyAppsByGroupId(long groupId) {

		return myappPersistence.findByGroupId(groupId);
	}

	public List<Myapp> getMyAppsByGroupId(long groupId, int start, int end) {

		return myappPersistence.findByGroupId(groupId, start, end);
	}

	public List<Myapp> getMyAppsByGroupId(long groupId, int start, int end,
			OrderByComparator<Myapp> orderByComparator) {

		return myappPersistence.findByGroupId(groupId, start, end, orderByComparator);
	}

	public List<Myapp> getMyAppsByKeywords(long groupId, String keywords, int start, int end,
			OrderByComparator<Myapp> orderByComparator) {

		return myappLocalService.dynamicQuery(getKeywordSearchDynamicQuery(groupId, keywords), start, end,
				orderByComparator);
	}

	public long getMyAppsCountByKeywords(long groupId, String keywords) {
		return myappLocalService.dynamicQueryCount(getKeywordSearchDynamicQuery(groupId, keywords));
	}

	private DynamicQuery getKeywordSearchDynamicQuery(long groupId, String keywords) {

		DynamicQuery dynamicQuery = dynamicQuery().add(RestrictionsFactoryUtil.eq("groupId", groupId));

		if (Validator.isNotNull(keywords)) {
			Disjunction disjunctionQuery = RestrictionsFactoryUtil.disjunction();

			disjunctionQuery.add(RestrictionsFactoryUtil.like("title", "%" + keywords + "%"));
			disjunctionQuery.add(RestrictionsFactoryUtil.like("description", "%" + keywords + "%"));
			dynamicQuery.add(disjunctionQuery);
		}

		return dynamicQuery;
	}
}