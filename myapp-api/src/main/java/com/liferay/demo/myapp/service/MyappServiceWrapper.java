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
 * Provides a wrapper for {@link MyappService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyappService
 * @generated
 */
public class MyappServiceWrapper
	implements MyappService, ServiceWrapper<MyappService> {

	public MyappServiceWrapper(MyappService myappService) {
		_myappService = myappService;
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp addMyApp(
			long groupId, long articleId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappService.addMyApp(
			groupId, articleId, title, description, serviceContext);
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp deleteMyApp(long myAppId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappService.deleteMyApp(myAppId);
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp getMyApp(long myappId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappService.getMyApp(myappId);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByGroupId(long groupId) {

		return _myappService.getMyAppsByGroupId(groupId);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp>
		getMyAppsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator) {

		return _myappService.getMyAppsByKeywords(
			groupId, keywords, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.demo.myapp.model.Myapp> getMyAppsByUserId(
		long userId) {

		return _myappService.getMyAppsByUserId(userId);
	}

	@Override
	public long getMyAppsCountByKeywords(long groupId, String keywords) {
		return _myappService.getMyAppsCountByKeywords(groupId, keywords);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _myappService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.demo.myapp.model.Myapp updateMyApp(
			long myAppId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myappService.updateMyApp(
			myAppId, title, description, serviceContext);
	}

	@Override
	public MyappService getWrappedService() {
		return _myappService;
	}

	@Override
	public void setWrappedService(MyappService myappService) {
		_myappService = myappService;
	}

	private MyappService _myappService;

}