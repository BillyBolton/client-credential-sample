/**
 This class is used to override the default way Spring handles 'Accept' headers, since we want to provide XML only for application/xml explicitely, NOT  requests of the type "Accept: text/html, ..., application/xml"
*/
package org.example.entities.openapi;

import java.io.IOException;

import org.example.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenApiSpecController {
  @Value("${openapi.file}")
  private String openapiFile;

  // because of our CustomContentNegotiation filter, this needs to return JSON
  @GetMapping(value = "${openapi.path}", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody String getOpenApiSpec() throws IOException {
    Resource resource = new ClassPathResource(openapiFile);
    String data = new String(resource.getInputStream().readAllBytes());
    if (openapiFile.contains(".yaml") || openapiFile.contains(".yml")) {
      return Utils.convertYamlToJson(data);
    } else if (openapiFile.contains(".json")) {
      return data;
    }
    throw new Error("Invalid openapi spec format, must be one of [.yaml, .yml, .json]");
  }
}