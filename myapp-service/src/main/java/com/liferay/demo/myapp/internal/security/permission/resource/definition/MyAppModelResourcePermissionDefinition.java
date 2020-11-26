package com.liferay.demo.myapp.internal.security.permission.resource.definition;

import com.liferay.demo.myapp.constants.MyAppConstants;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.MyappLocalService;
import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.definition.ModelResourcePermissionDefinition;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;

import java.util.function.Consumer;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author liferay
 */
@Component(
    immediate = true, 
    service = ModelResourcePermissionDefinition.class
)
public class MyAppModelResourcePermissionDefinition
    implements ModelResourcePermissionDefinition<Myapp> {

    @Override
    public Myapp getModel(long myappId)
        throws PortalException {

        return myAppLocalService.getMyapp(myappId);
    }

    @Override
    public Class<Myapp> getModelClass() {

        return Myapp.class;
    }

    @Override
    public PortletResourcePermission getPortletResourcePermission() {

        return _portletResourcePermission;
    }

    @Override
    public long getPrimaryKey(Myapp myApp) {

        return myApp.getMyappId();
    }

    @Override
    public void registerModelResourcePermissionLogics(
        ModelResourcePermission<Myapp> modelResourcePermission,
        Consumer<ModelResourcePermissionLogic<Myapp>> modelResourcePermissionLogicConsumer) {

        modelResourcePermissionLogicConsumer.accept(
            new StagedModelPermissionLogic<>(
                _stagingPermission,
                "com_liferay_demo_myapp_web_portlet_MyAppPortlet",
                Myapp::getMyappId));

        // Only enable if you use (optional) workflow support

        //    modelResourcePermissionLogicConsumer.accept(
        //        new WorkflowedModelPermissionLogic<>(
        //            _workflowPermission, modelResourcePermission,
        //            _groupLocalService, Assignment::getAssignmentId));
    }

    @Reference
    private MyappLocalService myAppLocalService;

    @Reference
    private GroupLocalService _groupLocalService;

    @Reference(target = "(resource.name=" + MyAppConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;
}