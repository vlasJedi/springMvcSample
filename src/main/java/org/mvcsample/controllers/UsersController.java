package org.mvcsample.controllers;

import org.mvcsample.dao.UsersDAO;
import org.mvcsample.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//String MVC type
@Controller
@RequestMapping("/users")
public class UsersController {
    private final UsersDAO usersDAO;

    @Autowired
    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    // HTTP GET
    // HttpServletRequest is container for all info about the request
    // and is injected by Spring automatically
    // better to use @RequestParam for request parameters
    @GetMapping("/{id}")
    public String getUser(
            @PathVariable("id") Integer id,
            // thymeleaf will use it to render template
            Model uiContextData) {
        User user = usersDAO.get(id);
        if (user == null) return null;
        uiContextData.addAttribute("user", user);
        // this is view name returned to be rendered
        // by templating engine
        return "user";
    }

    @GetMapping()
    public String getUsers(Model uiContextData) {
        uiContextData.addAttribute("users", usersDAO.getAll());
        return "users";
    }
}
