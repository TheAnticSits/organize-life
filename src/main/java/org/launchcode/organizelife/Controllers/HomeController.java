package org.launchcode.organizelife.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("life")
public class HomeController {

    @RequestMapping(value = "")

    public String index(Model model){
        model.addAttribute("title", "Organize Your Life");
        return "home/index";
    }
}
