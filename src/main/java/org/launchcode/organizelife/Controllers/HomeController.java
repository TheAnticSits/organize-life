package org.launchcode.organizelife.Controllers;

import org.launchcode.organizelife.Models.Task;
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


    ArrayList<Task> tasks = new ArrayList<>();
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

        Task newTask = new Task(taskName, importance);

        tasks.add(newTask);


/*        tasks.add(taskName);
        tasks.add(importance);*/
        return "redirect:";
    }



    @RequestMapping(value = "theday", method = RequestMethod.GET)
    public String displayRemoveTaskForm(Model model) {
        model.addAttribute("title", "Today's Tasks");
        model.addAttribute("title", "Check off What you've Completed");
        return "home/theday";
    }

    @RequestMapping(value = "theday", method = RequestMethod.POST)
    public String processRemoveTaskForm(@RequestParam String taskName) {

        /*for (String task : taskName) {
            task.remove(taskName);
            TODO make this able to remove tasks that were entered.
        }*/
        System.out.println("Remove Goes Here!");
        return "redirect:";
    }


    @RequestMapping(value = "theday")

    public String today(Model model){


        model.addAttribute("tasks", tasks);
        model.addAttribute("title", "Organize Your Life!");

        return "home/theday";
    }
}
