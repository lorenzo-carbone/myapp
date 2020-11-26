package com.liferay.demo.myapp.web.portlet.action;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.MyappService;
import com.liferay.demo.myapp.web.constants.MVCCommandNames;
import com.liferay.demo.myapp.web.constants.MyAppPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * MVC command for showing the assignments list.
 * 
 * @author liferay
 */
@Component(
    immediate = true, 
    property = {
        "javax.portlet.name=" + MyAppPortletKeys.MYAPP,
        "mvc.command.name=" + MVCCommandNames.SELECT_APP
    }, 
    service = MVCActionCommand.class
)
public class SelectAppMVCActionCommand extends BaseMVCActionCommand {
	
	@Reference
	private MyappService myAppService;

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		String[] values = ParamUtil.getParameterValues(actionRequest, "values", new String[0]);
    	
    	ServiceContext serviceContext = ServiceContextFactory.getInstance(
                Myapp.class.getName(), actionRequest);
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
    	long userId = themeDisplay.getUserId();
    	 
    	List<Myapp> myApps = myAppService.getMyAppsByUserId(userId);
    	for (Myapp myApp : myApps) {
    		System.out.println(myApp.getMyappId());
    		myAppService.deleteMyApp(myApp.getMyappId());
		}
    	
    	for (String articleId : values) {
    		myAppService.addMyApp(themeDisplay.getScopeGroupId(), Long.parseLong(articleId), null, null, serviceContext);
		}
	}

	
}