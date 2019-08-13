package org.launchcode.organizelife.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        model.addAttribute("title", "New Tasks!");
        model.addAttribute("date", date);
        return "home/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTaskForm(@RequestParam String taskName, @RequestParam String importance){
        tasks.add(taskName);


        return "redirect:";
    }

    @RequestMapping(value = "today")

    public String today(Model model){


        model.addAttribute("tasks", tasks);
        model.addAttribute("title", "Organize Your Life!");

        return "home/today";
    }
}
