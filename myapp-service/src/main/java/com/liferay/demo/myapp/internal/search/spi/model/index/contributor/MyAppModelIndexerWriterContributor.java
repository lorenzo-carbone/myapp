package com.liferay.demo.myapp.internal.search.spi.model.index.contributor;

import com.liferay.demo.myapp.model.Myapp;
import com.liferay.demo.myapp.service.MyappLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true, 
    property = "indexer.class.name=com.liferay.demo.myapp.model.Myapp", 
    service = ModelIndexerWriterContributor.class
)
public class MyAppModelIndexerWriterContributor
    implements ModelIndexerWriterContributor<Myapp> {

    @Override
    public void customize(
        BatchIndexingActionable batchIndexingActionable,
        ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

        batchIndexingActionable.setPerformActionMethod(
            (Myapp myApp) -> {
                Document document =
                    modelIndexerWriterDocumentHelper.getDocument(myApp);

                batchIndexingActionable.addDocuments(document);
            });
    }

    @Override
    public BatchIndexingActionable getBatchIndexingActionable() {

        return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
            myAppLocalService.getIndexableActionableDynamicQuery());
    }

    @Override
    public long getCompanyId(Myapp myApp) {

        return myApp.getCompanyId();
    }

    @Reference
    protected MyappLocalService myAppLocalService;

    @Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

}