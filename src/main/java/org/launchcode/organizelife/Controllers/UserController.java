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
    public String add(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("title", "Create New User");

        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUser(Model model, @RequestParam String userName, @RequestParam String email, @RequestParam String password, @RequestParam String passwordVerify) {
        User newUser = new User(userName, email, password, passwordVerify);
/*

        TODO this is comparing correctly.  Now I need to send it to correct pages and of course make it persistant
        TODO need to return the typed info of username and email back to the view
*/

        if(password.equals(passwordVerify)){
            users.add(newUser);

            return "home/congratulations";
        }else {

            return "user/add?name=" + newUser.getUserName();
        }
    }
}

