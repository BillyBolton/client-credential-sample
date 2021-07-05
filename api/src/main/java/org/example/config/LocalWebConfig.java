package org.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile("local")
@Configuration
public class LocalWebConfig implements WebMvcConfigurer {
  // put stuff here you only wanted loaded when running locally (i.e. 'local'
  // profile is active)
}
