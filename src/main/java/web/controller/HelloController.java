package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.model.User;
import web.service.UserServiceImp;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {


    private final UserServiceImp userServiceImp;


    @Autowired
    public HelloController( UserServiceImp userServiceImp) {

        this.userServiceImp = userServiceImp;
    }
    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        List<User> users = userServiceImp.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImp.deleteUser(id);
        return "redirect:/";
    }


}