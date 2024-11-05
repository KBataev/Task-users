package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<User> users = userServiceImp.getUsers();  // Получаем список пользователей

        // Добавляем список пользователей в модель
        model.addAttribute("users", users);




        return "index";
    }


}