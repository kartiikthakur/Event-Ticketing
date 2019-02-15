package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class NavigationController {
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/concerts")
    public String concerts(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Concert"));
        return "concerts";
    } 

    @RequestMapping("/buyTickets")
    public String buyTickets(Model model, @RequestParam int eventID) {
        model.addAttribute("event", eventRepository.findByEventID(eventID));
        return "buyTickets";
    }

    @GetMapping("/festival")
    public String festival(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Festival"));
        return "festival";
    }

    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Gallery"));
        return "gallery";
    }

    @GetMapping("/parties")
    public String parties(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Party"));
        return "parties";
    }

    @GetMapping("/sports")
    public String sports(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Sport"));
        return "sports";
    }

    @GetMapping("/theater")
    public String theater(Model model) {
        model.addAttribute("events", eventRepository.findByEventCategory("Theater"));
        return "theater";
    }

    @GetMapping("/upcoming")
    public String upcoming(Model model) {
        model.addAttribute("events", eventRepository.findByStatus(true));
        return "upcoming";
    }

    

}
