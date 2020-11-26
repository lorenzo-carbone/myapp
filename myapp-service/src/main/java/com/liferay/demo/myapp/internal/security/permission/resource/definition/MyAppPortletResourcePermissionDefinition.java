package com.liferay.demo.myapp.internal.security.permission.resource.definition;

import com.liferay.demo.myapp.constants.MyAppConstants;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.PortletResourcePermissionDefinition;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
    immediate = true, 
    service = PortletResourcePermissionDefinition.class
)
public class MyAppPortletResourcePermissionDefinition
    implements PortletResourcePermissionDefinition {

    @Override
    public PortletResourcePermissionLogic[] getPortletResourcePermissionLogics() {

        return new PortletResourcePermissionLogic[] {
            new StagedPortletPermissionLogic(
                _stagingPermission,
                "com_liferay_demo_myapp_web_portlet_MyAppPortlet")
        };
    }

    @Override
    public String getResourceName() {

        return MyAppConstants.RESOURCE_NAME;
    }

    @Reference
    private StagingPermission _stagingPermission;

}