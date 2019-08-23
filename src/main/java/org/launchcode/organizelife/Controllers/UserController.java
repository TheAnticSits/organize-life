package org.launchcode.organizelife.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "user")
    public String index(Model model){


        model.addAttribute("user");
        model.addAttribute("title", "Organize Your Life!");

        return "home/index";
    }
}
