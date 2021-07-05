package org.example.config;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class JsonOrYamlPropertySourceFactory implements PropertySourceFactory {

  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
    if (name.contains(".yaml") || name.contains(".yml")) {
      YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
      factory.setResources(encodedResource.getResource());
      Properties properties = factory.getObject();
      return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
    } else {
      @SuppressWarnings("unchecked")
      Map<String, Object> readValue = new ObjectMapper().readValue(encodedResource.getInputStream(), Map.class);
      return new MapPropertySource("json-property", readValue);
    }
  }
}
