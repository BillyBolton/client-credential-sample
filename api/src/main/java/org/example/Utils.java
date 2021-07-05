package org.example;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.yaml.snakeyaml.Yaml;

public class Utils {
  public static String convertYamlToJson(String data) throws JsonProcessingException {
    Yaml yaml = new Yaml();
    Map<Object, Object> document = yaml.load(data);

    ObjectMapper jsonWriter = new ObjectMapper();
    return jsonWriter.writeValueAsString(document);
  }
}
