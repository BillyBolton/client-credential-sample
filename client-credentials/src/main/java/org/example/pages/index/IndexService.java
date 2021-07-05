package org.example.pages.index;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.example.entities.employees.EmployeeDTO;
import org.example.util.ApiClient;
import org.example.util.JsonBodyHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
  private static final Logger log = LoggerFactory.getLogger(IndexService.class);

  public List<EmployeeDTO> getEmployees() {
    log.debug("Getting employees");
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://localhost:9443/employees"))
        .timeout(Duration.ofMinutes(1)).GET().build();

    @SuppressWarnings("unchecked")
    Class<List<EmployeeDTO>> clazz = (Class) List.class;
    try {
      List<EmployeeDTO> employees = ApiClient.getApiClient()
          .send(request, new JsonBodyHandler<List<EmployeeDTO>>(clazz)).body().get();

      log.debug("" + employees.size());
      return employees;

    } catch (IOException | InterruptedException e) {
      log.error(e.getMessage());
      return new ArrayList<EmployeeDTO>();
    }
  }
}
