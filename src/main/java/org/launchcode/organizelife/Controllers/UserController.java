package org.launchcode.organizelife.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute("title", "Create New User");

        return "user/add";
    }
    @RequestMapping( value = "add", method = RequestMethod.POST)
    public String processAddUser(Model model, @RequestParam String taskName, @RequestParam String importance) {


        return "redirect:";
    }
}
