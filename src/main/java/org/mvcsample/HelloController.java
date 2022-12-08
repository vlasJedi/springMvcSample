package org.mvcsample;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//String MVC type
@Controller
//@RequestMapping("url-prefix")
public class HelloController {
    // HTTP GET
    @GetMapping("/hello-world")
    public String sayHello(
            // HttpServletRequest is container for all info about the request
            // and is injected by Spring automatically
            // better to use @RequestMapping
            HttpServletRequest request,
            // thymeleaf will use it to render template
            Model uiContextData) {
        String username = request.getParameter("user") != null
                ? request.getParameter("user")
                : "missing";
        uiContextData.addAttribute("username", username);
        // this is view name returned to be rendered
        // by templating engine
        return "hello_world";
    }
}
