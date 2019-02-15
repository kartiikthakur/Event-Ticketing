package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/signin")
    public String loginPage() {
        return "signin";
    }
}
