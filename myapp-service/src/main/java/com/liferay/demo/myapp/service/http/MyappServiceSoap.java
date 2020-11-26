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

package com.liferay.demo.myapp.service.http;

import com.liferay.demo.myapp.service.MyappServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>MyappServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.demo.myapp.model.MyappSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.demo.myapp.model.Myapp</code>, that is translated to a
 * <code>com.liferay.demo.myapp.model.MyappSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyappServiceHttp
 * @generated
 */
public class MyappServiceSoap {

	public static com.liferay.demo.myapp.model.MyappSoap addMyApp(
			long groupId, long articleId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.demo.myapp.model.Myapp returnValue =
				MyappServiceUtil.addMyApp(
					groupId, articleId, title, description, serviceContext);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap deleteMyApp(
			long myAppId)
		throws RemoteException {

		try {
			com.liferay.demo.myapp.model.Myapp returnValue =
				MyappServiceUtil.deleteMyApp(myAppId);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap getMyApp(long myappId)
		throws RemoteException {

		try {
			com.liferay.demo.myapp.model.Myapp returnValue =
				MyappServiceUtil.getMyApp(myappId);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap[] getMyAppsByUserId(
			long userId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.demo.myapp.model.Myapp> returnValue =
				MyappServiceUtil.getMyAppsByUserId(userId);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap[] getMyAppsByGroupId(
			long groupId)
		throws RemoteException {

		try {
			java.util.List<com.liferay.demo.myapp.model.Myapp> returnValue =
				MyappServiceUtil.getMyAppsByGroupId(groupId);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap[] getMyAppsByKeywords(
			long groupId, String keywords, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.demo.myapp.model.Myapp> orderByComparator)
		throws RemoteException {

		try {
			java.util.List<com.liferay.demo.myapp.model.Myapp> returnValue =
				MyappServiceUtil.getMyAppsByKeywords(
					groupId, keywords, start, end, orderByComparator);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static long getMyAppsCountByKeywords(long groupId, String keywords)
		throws RemoteException {

		try {
			long returnValue = MyappServiceUtil.getMyAppsCountByKeywords(
				groupId, keywords);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.liferay.demo.myapp.model.MyappSoap updateMyApp(
			long myAppId, String title, String description,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.demo.myapp.model.Myapp returnValue =
				MyappServiceUtil.updateMyApp(
					myAppId, title, description, serviceContext);

			return com.liferay.demo.myapp.model.MyappSoap.toSoapModel(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(MyappServiceSoap.class);

}