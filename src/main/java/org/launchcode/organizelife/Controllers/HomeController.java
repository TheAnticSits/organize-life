
package org.launchcode.organizelife.Controllers;
import org.launchcode.organizelife.Models.Task;
import org.launchcode.organizelife.Models.data.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private TaskDao taskDao;

    ArrayList<Task> tasks = new ArrayList<>();
    @RequestMapping(value = "")


    public String index(Model model){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        model.addAttribute("tasks", taskDao.findAll());
        model.addAttribute("title", "Organize Your Life!");
        model.addAttribute("date", date);
        model.addAttribute("totalTime", getSumofTimes());


        return "home/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTaskForm(Model model){

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());

        model.addAttribute("title", "New Tasks!");
        model.addAttribute("date", date);
        return "home/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTaskForm(@ModelAttribute Task newTask, Model model){


        taskDao.save(newTask);

        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveTaskForm(Model model) {
        model.addAttribute("tasks", taskDao.findAll());
        model.addAttribute("title", "Check Off What you've Completed");
        return "home/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveTaskForm(@RequestParam int[] taskIds) {

        for(int taskId : taskIds){
            taskDao.deleteById(taskId);

        }
//        TODO Fix this breaks when no tasks are checked off and remove is selected.


        return "redirect:";
    }

    public double getSumofTimes(){

        double output = 0;
        Iterable<Task> times = taskDao.findAll();
        for(Task time : times){

            output += time.getTime();
        }

        return output;

    }

}
