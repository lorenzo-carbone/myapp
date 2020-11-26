package com.liferay.demo.myapp.selected.config;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

@ExtendedObjectClassDefinition(category = "my-app", scope = ExtendedObjectClassDefinition.Scope.GROUP)
 
@Meta.OCD(id = "com.liferay.demo.myapp.selected.config.MyAppConfiguration", localization = "content/Language", name = "my-app-selected")
 
public interface MyAppConfiguration {
 
    @Meta.AD(deflt = "", 
            name = "structureId",
            required = false)
 
    public String structureId();
    
    @Meta.AD(deflt = "", 
            name = "contentSetId",
            required = false)
 
    public String contentSetId();
}