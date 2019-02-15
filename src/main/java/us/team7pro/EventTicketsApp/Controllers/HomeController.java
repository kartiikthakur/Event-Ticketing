package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.*;

@Controller
public class HomeController {

    @Autowired EventRepository eventRepository;

    @GetMapping("/")
    public String homepage(Model model) {
        // model.addAttribute("events", eventRepository.findAll());
        model.addAttribute("events", eventRepository.findByStatus(true));
       
        return "homepage";
    }

    @PostMapping("search")
    public String search(Model model, @RequestParam("event_name") String event_name,
     @RequestParam("event_location") String event_location, HttpSession session)throws IOException{
        System.out.println(event_name);
        System.out.println(event_location);

        if(event_name.equals("")&& event_location.equals("")){
            return "homepage";
        } else if(event_name.equals("")){
            model.addAttribute("events", eventRepository.findByLocationContaining(event_location));
        } else if(event_location.equals("")){
            model.addAttribute("events", eventRepository.findByEventNameContaining(event_name));
        } else {
            model.addAttribute("events", eventRepository.findByEventNameContainingOrLocationContaining(event_name, event_location));
        }       
        // System.out.println()
        return "searchResults";
     }
}
