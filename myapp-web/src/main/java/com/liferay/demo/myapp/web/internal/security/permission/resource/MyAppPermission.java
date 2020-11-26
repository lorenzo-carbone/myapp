package com.liferay.demo.myapp.web.internal.security.permission.resource;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
    immediate = true, 
    service = MyAppPermission.class
)
public class MyAppPermission {

    public static boolean contains(
            PermissionChecker permissionChecker, Myapp myApp,
            String actionId)
        throws PortalException {

        return myAppModelResourcePermission.contains(
            permissionChecker, myApp, actionId);
    }

    public static boolean contains(
            PermissionChecker permissionChecker, long assignmentId, String actionId)
        throws PortalException {

        return myAppModelResourcePermission.contains(
            permissionChecker, assignmentId, actionId);
    }

    @Reference(
        target = "(model.class.name=com.liferay.demo.myapp.model.Myapp)",
        unbind = "-"
    )
    protected void setEntryModelPermission(
        ModelResourcePermission<Myapp> modelResourcePermission) {

        myAppModelResourcePermission = modelResourcePermission;
    }

    private static ModelResourcePermission<Myapp>
    myAppModelResourcePermission;

}