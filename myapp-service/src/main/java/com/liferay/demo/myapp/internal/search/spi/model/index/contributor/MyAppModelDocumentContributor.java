package com.liferay.demo.myapp.internal.search.spi.model.index.contributor;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true, 
    property = "indexer.class.name=com.liferay.demo.myapp.model.Myapp", 
    service = ModelDocumentContributor.class
)
public class MyAppModelDocumentContributor
    implements ModelDocumentContributor<Myapp> {

    @Override
    public void contribute(Document document, Myapp myApp) {

        // Strip HTML.

        String description = HtmlUtil.extractText(myApp.getDescription());
        document.addText(Field.DESCRIPTION, description);

        String title = HtmlUtil.extractText(myApp.getTitle());
        document.addText(Field.TITLE, title);

        document.addDate(Field.MODIFIED_DATE, myApp.getModifiedDate());

        // Handle localized fields.

        for (Locale locale : LanguageUtil.getAvailableLocales(
            myApp.getGroupId())) {

            String languageId = LocaleUtil.toLanguageId(locale);

            document.addText(
                LocalizationUtil.getLocalizedName(
                    Field.DESCRIPTION, languageId),
                description);
            document.addText(
                LocalizationUtil.getLocalizedName(Field.TITLE, languageId),
                title);
        }
    }
}