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
 * Provides the remote service utility for Myapp. This utility wraps
 * <code>com.liferay.demo.myapp.service.impl.MyappServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MyappService
 * @generated
 */
public class MyappServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.demo.myapp.service.impl.MyappServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.demo.myapp.model.Myapp addMyApp(
			long groupId, long articleId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addMyApp(
			groupId, articleId, title, description, serviceContext);
	}

	public static com.liferay.demo.myapp.model.Myapp deleteMyApp(long myAppId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMyApp(myAppId);
	}

	public static com.liferay.demo.myapp.model.Myapp getMyApp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMyApp(myappId);
	}

	public static java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId) {

		return getService().getMyAppsByGroupId(groupId);
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

	public static com.liferay.demo.myapp.model.Myapp updateMyApp(
			long myAppId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateMyApp(
			myAppId, title, description, serviceContext);
	}

	public static MyappService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MyappService, MyappService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(MyappService.class);

		ServiceTracker<MyappService, MyappService> serviceTracker =
			new ServiceTracker<MyappService, MyappService>(
				bundle.getBundleContext(), MyappService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}