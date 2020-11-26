package com.liferay.demo.myapp.web.portlet.action;

import com.liferay.demo.myapp.config.MyAppConfiguration;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.MyappService;
import com.liferay.demo.myapp.web.constants.MVCCommandNames;
import com.liferay.demo.myapp.web.constants.MyAppPortletKeys;
import com.liferay.demo.myapp.web.internal.security.permission.resource.MyAppPermission;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
        "mvc.command.name=/",
        "mvc.command.name=" + MVCCommandNames.VIEW_MYAPPS
    }, 
    service = MVCRenderCommand.class
)
public class ViewMyAppsMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	protected MyAppPermission myAppPermission;
	
	@Reference
	private DDMStructureLocalService ddmStuctureLocalService;
	
	@Reference
	private JournalArticleService journalArticleService;
	
	private ConfigurationProvider configurationProvider;
	 
    @Reference(unbind = "-")
    protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
        this.configurationProvider = configurationProvider;
    }
	
    @Override
    public String render(
        RenderRequest renderRequest, RenderResponse renderResponse)
        throws PortletException {
    	
        // Add assignment list related attributes.

        addMyAppListAttributes(renderRequest);
        
        renderRequest.setAttribute("myAppPermission", myAppPermission);
        
        return "/view.jsp";
    }

    /**
     * Adds assigment list related attributes to the request.
     * 
     * @param renderRequest
     */
    private void addMyAppListAttributes(RenderRequest renderRequest) {

        ThemeDisplay themeDisplay =
            (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        String siteId = (String) renderRequest.getAttribute("siteId");
		
		long groupId = siteId == null ? themeDisplay.getSiteGroupId() : Long.parseLong(siteId);
		List<KeyValuePair> leftBox = new ArrayList<KeyValuePair>();
		List<KeyValuePair> rightBox = new ArrayList<KeyValuePair>();
		List<KeyValuePair> sitesList = new ArrayList<KeyValuePair>();
		
		long userId = themeDisplay.getUserId();
		User user = themeDisplay.getUser();
		List<Group> sites;
		try {
			sites = user.getMySiteGroups();
			for(Group site: sites){
				sitesList.add(new KeyValuePair(String.valueOf(site.getGroupId()), GroupLocalServiceUtil.getGroup(site.getGroupId()).getDescriptiveName()));
			}
		} catch (PortalException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		// Get Selected app from MyAppLocalService
		List<Myapp> myApps = new ArrayList<Myapp>();
		try {
			myApps = myAppService.getMyAppsByUserId(userId);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String ddStructureKey = "";
		MyAppConfiguration myAppConfiguration;
        try {
        	myAppConfiguration = configurationProvider.getCompanyConfiguration(MyAppConfiguration.class,themeDisplay.getCompanyId());
            ddStructureKey = myAppConfiguration.structureId().toString();
        } catch (ConfigurationException e) {
            System.out.println("No config");
        }
		
		OrderByComparator<JournalArticle> comparator = OrderByComparatorFactoryUtil.create("JournalArticle", "displayDate", "desc");
		List<JournalArticle> journalArticles = journalArticleService.getArticlesByStructureId(groupId, ddStructureKey, 0, 99, comparator);

		for (JournalArticle journalArticle : journalArticles) {
			try {
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, journalArticle.getArticleId(), journalArticle.getVersion())){
					String content = journalArticle.getContentByLocale(themeDisplay.getLocale().toString());
					Document document;
					document = SAXReaderUtil.read(content);
					Element rootElement = document.getRootElement();
					for (Element e : rootElement.elements()) {
					  if (e.getName().equals("dynamic-element") && e.attributeValue("name").equals("Title")) {
					    String value = e.element("dynamic-content").getTextTrim();
					    boolean appSelected = myApps.stream().anyMatch(c -> c.getArticleId() == Long.parseLong(journalArticle.getArticleId()));
					    if(appSelected) {
					    	rightBox.add(new KeyValuePair(journalArticle.getArticleId(), value));
					    } else {
					    	leftBox.add(new KeyValuePair(journalArticle.getArticleId(), value));
					    }
					    
					  }
					}
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (DocumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		renderRequest.setAttribute("currentSiteId", groupId);
		renderRequest.setAttribute("leftBox", leftBox);
		renderRequest.setAttribute("rightBox", rightBox);
		renderRequest.setAttribute("sites", sitesList);

    }

    @Reference
    protected MyappService myAppService;

    @Reference
    private Portal _portal;
}