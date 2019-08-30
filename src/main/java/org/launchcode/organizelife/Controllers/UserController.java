package org.launchcode.organizelife.Controllers;

import org.launchcode.organizelife.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {

    static ArrayList<User> users = new ArrayList<>();

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute User user, String verify){
        model.addAttribute("title", "Create New User");

        return "user/add";
    }
    @RequestMapping( value = "add", method = RequestMethod.POST)
    public String processAddUser(Model model, @RequestParam String userName, @RequestParam String email, @RequestParam String password, @RequestParam String passwordVerify) {
        User newUser = new User(userName, email, password, passwordVerify);

        if (newUser.getPassword() == newUser.getPasswordVerify()) {
            users.add(newUser);
            System.out.println("worked");
            return "user/add";
        }
        System.out.println("didn't work");
        return "user/add";
    }
}
