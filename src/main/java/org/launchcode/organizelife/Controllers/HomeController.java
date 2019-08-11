package org.launchcode.organizelife.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("home")
public class HomeController {

    ArrayList<String> tasks = new ArrayList<>();
    @RequestMapping(value = "")

    public String index(Model model){


        model.addAttribute("tasks", tasks);
        model.addAttribute("title", "Organize Your Life!");
        return "home/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayTaskForm(Model model){
        model.addAttribute("title", "New Tasks!");
        return "home/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTaskForm(@RequestParam String taskName){
        tasks.add(taskName);
        
        return "redirect:";
    }
}
