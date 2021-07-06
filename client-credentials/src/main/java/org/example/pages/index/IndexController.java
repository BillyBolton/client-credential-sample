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
  @PreAuthorize("hasRole('APPROLE_Task.Read')")
  public String index(Model model) {
    System.out.println("another test");
    model.addAttribute("employees", indexService.getEmployees());
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
