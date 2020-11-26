package com.liferay.demo.myapp.web.asset.model;

import com.liferay.asset.display.page.portlet.AssetDisplayPageFriendlyURLProvider;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.demo.myapp.constants.MyAppConstants;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.MyappLocalService;
import com.liferay.demo.myapp.web.constants.MVCCommandNames;
import com.liferay.demo.myapp.web.constants.MyAppPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Portal;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Asset renderer factory component for MyApp.
 *
 * @author liferay
 */
@Component(
    immediate = true,
    property = "javax.portlet.name=" + MyAppPortletKeys.MYAPP,
    service = AssetRendererFactory.class
)
public class MyAppAssetRendererFactory
    extends BaseAssetRendererFactory<Myapp> {

    public static final String CLASS_NAME = Myapp.class.getName();

    public static final String TYPE = "myApp";

    public MyAppAssetRendererFactory() {
        setClassName(CLASS_NAME);
        setLinkable(true);
        setPortletId(MyAppPortletKeys.MYAPP);
        setSearchable(true);
    }

    @Override
    public AssetRenderer<Myapp> getAssetRenderer(long classPK, int type)
        throws PortalException {

    	Myapp myApp = myAppLocalService.getMyapp(classPK);

    	MyAppAssetRenderer myAppAssetRenderer = new MyAppAssetRenderer(myApp);

    	myAppAssetRenderer.setAssetDisplayPageFriendlyURLProvider( 
            _assetDisplayPageFriendlyURLProvider);
    	myAppAssetRenderer.setAssetRendererType(type);
    	myAppAssetRenderer.setServletContext(_servletContext);

        return myAppAssetRenderer;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public PortletURL getURLAdd(
        LiferayPortletRequest liferayPortletRequest,
        LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = _portal.getControlPanelPortletURL(
            liferayPortletRequest, getGroup(liferayPortletRequest),
            MyAppPortletKeys.MYAPP, 0, 0, PortletRequest.RENDER_PHASE);

        portletURL.setParameter("mvcRenderCommandName", MVCCommandNames.VIEW_MYAPPS);

        return portletURL;
    }

    @Override
    public PortletURL getURLView(
        LiferayPortletResponse liferayPortletResponse,
        WindowState windowState) {

        LiferayPortletURL liferayPortletURL =
            liferayPortletResponse.createLiferayPortletURL(
            		MyAppPortletKeys.MYAPP, PortletRequest.RENDER_PHASE);

        try {
            liferayPortletURL.setWindowState(windowState);
        }
        catch (WindowStateException wse) {
        }

        return liferayPortletURL;
    }    

    @Override
    public boolean hasAddPermission(
            PermissionChecker permissionChecker, long groupId, long classTypeId)
        throws Exception {

        return _portletResourcePermission.contains(
            permissionChecker, groupId, ActionKeys.ADD_ENTRY);
    }

    @Override
    public boolean hasPermission(
            PermissionChecker permissionChecker, long classPK, String actionId)
        throws Exception {

        return myAppModelResourcePermission.contains(
            permissionChecker, classPK, actionId);
    }

    @Reference
    private AssetDisplayPageFriendlyURLProvider
        _assetDisplayPageFriendlyURLProvider;

    @Reference
    private MyappLocalService myAppLocalService;

    @Reference(
        target = "(model.class.name=com.liferay.demo.myapp.model.Myapp)"
    )
    private ModelResourcePermission<Myapp>
        myAppModelResourcePermission;

    @Reference
    private Portal _portal;

    @Reference(
        target = "(resource.name=" + MyAppConstants.RESOURCE_NAME + ")"
    )
    private PortletResourcePermission _portletResourcePermission;

    @Reference
    private PortletURLFactory _portletURLFactory;

    @Reference(
        target = "(osgi.web.symbolicname=com.liferay.demo.myapp.web)"
    )
    private ServletContext _servletContext;

}