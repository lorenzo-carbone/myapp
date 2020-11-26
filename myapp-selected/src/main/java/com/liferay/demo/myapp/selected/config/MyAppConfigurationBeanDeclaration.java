package com.liferay.demo.myapp.selected.config;

import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

@Component(
        immediate = true, 
        service = ConfigurationBeanDeclaration.class)
 
public class MyAppConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {
 
    @Override
    public Class<?> getConfigurationBeanClass() {
        return MyAppConfiguration.class;
    }
}
