package org.example.pages.index;

import org.example.entities.employees.EmployeeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.Data;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.oauth2AuthorizedClient;

@Controller
public class IndexController {
  private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  @Autowired
  private IndexService indexService;

  @Autowired
  private WebClient webClient;

  @GetMapping("/")
  @PreAuthorize("hasAuthority('APPROLE_Task.Delete')")
  public String index(Model model,
      @RegisteredOAuth2AuthorizedClient("web-api") OAuth2AuthorizedClient client) {
    String employees =
        webClient.get().uri("https://tdd-playwright-example-api.herokuapp.com/employees/2")
            .attributes(oauth2AuthorizedClient(client)).retrieve().bodyToMono(String.class).block();
    model.addAttribute("employees", employees);
    return "index";
  }

  @PostMapping("/employees")
  public String index(@RequestBody FormBody formBody) {
    return "index";
  }

  @Data
  class FormBody {
    private String name;
    private String role;
  }
}
