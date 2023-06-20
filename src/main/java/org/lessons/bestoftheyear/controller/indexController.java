package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
 @GetMapping("/template")
 public String template(Model model){
  String name = "Marco";
  model.addAttribute("name", name);
  return "index";
 }
}
