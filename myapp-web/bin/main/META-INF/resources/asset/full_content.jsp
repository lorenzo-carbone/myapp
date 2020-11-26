<%@ include file="/init.jsp"%>

<%
    AssetRenderer<?> assetRenderer = (AssetRenderer<?>)request.getAttribute(WebKeys.ASSET_RENDERER);

    String viewEntryURL = assetRenderer.getURLView(liferayPortletResponse, WindowState.MAXIMIZED);

    Myapp myApp = (Myapp)request.getAttribute("myApp");                    
%>

<aui:a cssClass="title-link" href="<%= viewEntryURL %>">
    <h3 class="title"><%= HtmlUtil.escape(myApp.getTitle()) %></h3>
</aui:a>

<div class="autofit-col autofit-col-expand">
    <%= HtmlUtil.escape(myApp.getDescription()) %>
</div>

<div class="autofit-col autofit-col-expand">
    <%= myApp.getArticleId() %>
</div>