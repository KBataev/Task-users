package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceImp;

import java.util.List;

@Controller
public class HelloController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public HelloController(UserServiceImp userServiceImp) {
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

    @GetMapping("/add")
    public String addUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping()
    public String addUserPost(@ModelAttribute("user") User user) {
        userServiceImp.addUser(user);
        return "redirect:/";
    }


    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model) {
        User user = userServiceImp.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }


    @PostMapping("/updateUser")
    public String updateUserPost(@ModelAttribute("user") User user) {
        userServiceImp.updateUser(user);
        return "redirect:/";
    }
}
