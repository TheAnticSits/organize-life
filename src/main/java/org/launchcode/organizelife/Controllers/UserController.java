package org.launchcode.organizelife.Controllers;


import org.launchcode.organizelife.Models.User;
import org.launchcode.organizelife.Models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    static ArrayList<User> users = new ArrayList<>();

    @RequestMapping(value = "")
    public String index(Model model){
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "List of Users");

        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model, @ModelAttribute User user, String verify) {

        model.addAttribute("title", "Create New User");


        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUser(Model model, User user, @RequestParam String userName, @RequestParam String email, @RequestParam String password, @RequestParam String passwordVerify) {

        User newUser = new User(userName, email, password, passwordVerify);

/*
        TODO need to return the typed info of username and email back to the view
*/

        if(password.equals(passwordVerify)){
            users.add(newUser);
            model.addAttribute(newUser);
            userDao.save(newUser);
            return "user/index";
        }else {

            return "user/add";
        }
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model, @ModelAttribute User user, String verify) {

        model.addAttribute("title", "Log in");


        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processLogin(Model model, User user, @RequestParam String userName, @RequestParam String password) {

 //       if(checkUserName(userName, password)=true){
            return "user/add";
        }
/*        if(password.equals()){
            users.add(newUser);
            model.addAttribute(newUser);
            userDao.save(newUser);
            return "user/index";
        }else {*/

//            return "user/add";


//    public ArrayList<User> thisUser = new ArrayList<>();
/*public int checkUserName(String userName, String password) {


    Iterable<User> users = userDao.findAll();
    for (User user : users) {

        if (user.getUserName().equals(userName)) {
            return true;
        }

    }

    return false;
}*/

}

