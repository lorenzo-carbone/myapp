package com.liferay.demo.myapp.selected.web.portlet.action;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.list.asset.entry.provider.AssetListAssetEntryProvider;
import com.liferay.asset.list.model.AssetListEntry;
import com.liferay.asset.list.service.AssetListEntryServiceUtil;
import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.selected.config.MyAppConfiguration;
import com.liferay.demo.myapp.selected.web.constants.MVCCommandNames;
import com.liferay.demo.myapp.selected.web.constants.MyAppSelectedPortletKeys;
import com.liferay.demo.myapp.selected.web.dto.AppDTO;
import com.liferay.demo.myapp.service.MyappService;
import com.liferay.dynamic.data.mapping.service.DDMStructureLocalService;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.journal.service.JournalArticleService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CamelCaseUtil;
import com.liferay.portal.kernel.util.KeyValuePair;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.segments.context.Context;
import com.liferay.segments.provider.SegmentsEntryProviderRegistry;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	    immediate = true, 
	    property = {
	        "javax.portlet.name=" + MyAppSelectedPortletKeys.MYAPPSELECTED, 
	        "mvc.command.name=/",
	        "mvc.command.name=" + MVCCommandNames.VIEW_MYAPPS
	    }, 
	    service = MVCRenderCommand.class
	)
public class ViewMyAppSelectedMVCRenderCommand implements MVCRenderCommand {
	
	@Reference
	private DDMStructureLocalService ddmStuctureLocalService;
	
	@Reference
	private JournalArticleService journalArticleService;
	
	@Reference
	private MyappService myAppService;
	
	@Reference
	private LayoutLocalService layoutLocalService;
	
	private ConfigurationProvider configurationProvider;
	 
    @Reference(unbind = "-")
    protected void setConfigurationProvider(ConfigurationProvider configurationProvider) {
        this.configurationProvider = configurationProvider;
    }

    @Reference
	private AssetListAssetEntryProvider _assetListAssetEntryProvider;
    
    @Reference
	private SegmentsEntryProviderRegistry _segmentsEntryProviderRegistry;

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// Add assignment list related attributes.

        addMyAppListAttributes(renderRequest);
        
        return "/view.jsp";
	}
	
	private void addMyAppListAttributes(RenderRequest renderRequest) {

        ThemeDisplay themeDisplay =
            (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        
        String siteId = (String) renderRequest.getAttribute("siteId");
		
		long groupId = siteId == null ? themeDisplay.getSiteGroupId() : Long.parseLong(siteId);
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
		String contentSetId = "";
		MyAppConfiguration myAppConfiguration;
        try {
        	myAppConfiguration = configurationProvider.getCompanyConfiguration(MyAppConfiguration.class,themeDisplay.getCompanyId());
            ddStructureKey = myAppConfiguration.structureId().toString();
            contentSetId = myAppConfiguration.contentSetId().toString();
        } catch (ConfigurationException e) {
            System.out.println("No config");
        }
        
		OrderByComparator<JournalArticle> comparator = OrderByComparatorFactoryUtil.create("JournalArticle", "displayDate", "desc");
		List<JournalArticle> journalArticles = journalArticleService.getArticlesByStructureId(groupId, ddStructureKey, 0, 99, comparator);

		List<AppDTO> apps = new ArrayList<AppDTO>();
		boolean appSelected = false;
		
		for (JournalArticle journalArticle : journalArticles) {
			try {
				if(JournalArticleLocalServiceUtil.isLatestVersion(groupId, journalArticle.getArticleId(), journalArticle.getVersion())){
					appSelected = myApps.stream().anyMatch(c -> c.getArticleId() == Long.parseLong(journalArticle.getArticleId()));
					// App selected
					if(appSelected) {
						apps.add(getAppDTO(journalArticle, themeDisplay));
					}
				}
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(apps.isEmpty()) {
			try {
				AssetListEntry assetListEntry = AssetListEntryServiceUtil.getAssetListEntry(Long.parseLong(contentSetId));
				User contextUser = themeDisplay.getUser();
				long[] segmentsEntryIds =
						_segmentsEntryProviderRegistry.getSegmentsEntryIds(
							assetListEntry.getGroupId(), contextUser.getModelClassName(),
							contextUser.getPrimaryKey(), _createSegmentsContext(renderRequest));
				
				List<AssetEntry> contentSetEntries = _assetListAssetEntryProvider.getAssetEntries(
						assetListEntry, segmentsEntryIds,
						Pagination.of(1, 4).getStartPosition(), Pagination.of(1, 4).getEndPosition());
				
				for (AssetEntry assetEntry : contentSetEntries) {
					apps.add(getAppDTO(JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK()), themeDisplay));
				}
				
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		renderRequest.setAttribute("apps", apps);

    }
	
	private AppDTO getAppDTO(JournalArticle journalArticle, ThemeDisplay themeDisplay) {
		String title = "";
		String icon = "";
		String link = "";
		
		AppDTO app = new AppDTO();
		String content = journalArticle.getContentByLocale(themeDisplay.getLocale().toString());
		try {
			Document document;
			document = SAXReaderUtil.read(content);
			Element rootElement = document.getRootElement();
			for (Element e : rootElement.elements()) {
			  if (e.getName().equals("dynamic-element") && e.attributeValue("name").equals("Title")) {
			    title = e.element("dynamic-content").getTextTrim();
			    app.setTitle(title);
			  }
			  if (e.getName().equals("dynamic-element") && e.attributeValue("name").equals("IconType")) {
				icon = e.element("dynamic-content").getTextTrim();
			    app.setIcon(icon);
			  }
			  if (e.getName().equals("dynamic-element") && e.attributeValue("name").equals("LinkToPage")) {
				link = e.element("dynamic-content").getTextTrim();
				String[] linkElement = link.split("[@]");
				boolean isPrivate = linkElement[1].contains("private") ? true : false; 
				Layout layout = layoutLocalService.getLayout(Long.parseLong(linkElement[2]), isPrivate, Long.parseLong(linkElement[0]));
				link = PortalUtil.getLayoutFriendlyURL(layout, themeDisplay);
			    app.setLink(link);
			  }
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return app;
	}
	
	private Context _createSegmentsContext(RenderRequest renderRequest) {
		Context context = new Context();
		
		HttpServletRequest contextHttpServletRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		
		Enumeration<String> enumeration =
			contextHttpServletRequest.getHeaderNames();

		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();

			String value = contextHttpServletRequest.getHeader(key);

			if (key.equals("accept-language")) {
				context.put(
					Context.LANGUAGE_ID, StringUtil.replace(value, '-', '_'));
			}
			else if (key.equals("host")) {
				context.put(Context.URL, value);
			}
			else if (key.equals("referer")) {
				context.put(Context.REFERRER_URL, value);
			}
			else if (key.equals("user-agent")) {
				context.put(Context.USER_AGENT, value);
			}
			else if (key.startsWith("x-")) {
				context.put(
					CamelCaseUtil.toCamelCase(
						StringUtil.removeSubstring(key, "x-")),
					value);
			}
			else {
				context.put(key, value);
			}
		}

		context.put(Context.LOCAL_DATE, LocalDate.from(ZonedDateTime.now()));

		return context;
	}

}
