package org.example.pages.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.Data;

@Controller
public class IndexController {
  private static final Logger log = LoggerFactory.getLogger(IndexController.class);

  @Autowired
  private IndexService indexService;

  @GetMapping("/")
  // @PreAuthorize("hasRole('ROLE_group1')")
  public String index(Model model) {
    System.out.println("another test");
    model.addAttribute("employees", indexService.getEmployees());
    return "index";
  }

  @GetMapping("/webapiB/clientCredential")
  @ResponseBody
  public String clientCredential() {
    return "Response from webApiB: clientCredential";

  }

  @GetMapping("/webapiB")
  @ResponseBody
  @PreAuthorize("hasAuthority('SCOPE_WebApiB.ExampleScope')")
  public String file() {
    return "Response from webApiB.";
  }

  @GetMapping("/user")
  @ResponseBody
  @PreAuthorize("hasAuthority('SCOPE_User.Read')")
  public String user() {
    return "User read success.";
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
