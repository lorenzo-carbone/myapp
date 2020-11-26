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

import com.liferay.demo.myapp.constants.MyAppConstants;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.base.MyappServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the myapp remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.liferay.demo.myapp.service.MyappService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyappServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=myapp",
		"json.web.service.context.path=Myapp" }, service = AopService.class)
public class MyappServiceImpl extends MyappServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use
	 * <code>com.liferay.demo.myapp.service.MyappServiceUtil</code> to access the
	 * myapp remote service.
	 */
	
	@Reference(
	    policy = ReferencePolicy.DYNAMIC,
	    policyOption = ReferencePolicyOption.GREEDY,
	    target = "(model.class.name=com.liferay.demo.myapp.model.Myapp)"
	)
	private volatile ModelResourcePermission<Myapp>
	    myAppModelResourcePermission;

	@Reference(
	    policy = ReferencePolicy.DYNAMIC,
	    policyOption = ReferencePolicyOption.GREEDY,
	    target = "(resource.name=" + MyAppConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

	public Myapp addMyApp(long groupId, long articleId, String title, String description, ServiceContext serviceContext) throws PortalException {
		
		// Check permissions.
//        _portletResourcePermission.check(
//            getPermissionChecker(), serviceContext.getScopeGroupId(),
//            ActionKeys.ADD_ENTRY);

		return myappLocalService.addMyApp(groupId, articleId, title, description, serviceContext);
	}

	public Myapp deleteMyApp(long myAppId) throws PortalException {

		 // Check permissions.

		myAppModelResourcePermission.check(
            getPermissionChecker(), myAppId, ActionKeys.DELETE);
        
		Myapp myApp = myappLocalService.getMyapp(myAppId);

		return myappLocalService.deleteMyapp(myApp);
	}

	public Myapp getMyApp(long myappId) throws PortalException {

		Myapp myApp = myappLocalService.getMyapp(myappId);
		
		// Check permissions.

		myAppModelResourcePermission.check(
            getPermissionChecker(), myApp, ActionKeys.VIEW);


		return myApp;
	}

	public List<Myapp> getMyAppsByUserId(long userId) {

		return myappPersistence.findByUserId(userId);
	}
	
	public List<Myapp> getMyAppsByGroupId(long groupId) {

		return myappPersistence.filterFindByGroupId(groupId);
	}

	public List<Myapp> getMyAppsByKeywords(long groupId, String keywords, int start, int end,
			OrderByComparator<Myapp> orderByComparator) {

		return myappLocalService.getMyAppsByKeywords(groupId, keywords, start, end, orderByComparator);
	}

	public long getMyAppsCountByKeywords(long groupId, String keywords) {

		return myappLocalService.getMyAppsCountByKeywords(groupId, keywords);
	}

	public Myapp updateMyApp(long myAppId, String title,
			String description, ServiceContext serviceContext) throws PortalException {
		
		// Check permissions.

		myAppModelResourcePermission.check(
            getPermissionChecker(), myAppId, ActionKeys.UPDATE);

		return myappLocalService.updateMyApp(myAppId, title, description, serviceContext);
	}
	
}