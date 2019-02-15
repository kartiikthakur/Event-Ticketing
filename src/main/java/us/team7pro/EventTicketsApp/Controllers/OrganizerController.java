package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import java.io.IOException;

@Controller
public class OrganizerController { 
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/organizerdashboard")
    public String eventForm(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("events", eventRepository.findByOrganizerID(user.getId()));
        model.addAttribute("newEvent", new Event());
        return "organizerdashboard";
    }

    @PostMapping("/submitNewEvent")
    public String eventSubmit(@ModelAttribute Event newEvent, Model model, @AuthenticationPrincipal User user) {
        System.out.println(newEvent.getEventCategory());
        newEvent.setOrganizerID(user.getId());
        newEvent.setStatus(false);
        eventRepository.save(newEvent);
        model.addAttribute("newEvent", newEvent);
        return "redirect:/./organizerdashboard";
    }

    @RequestMapping(value="/deleteEvent", method = RequestMethod.GET)
    public String deleteEvent(@RequestParam(name="eventID") int eventID){
        Event event = eventRepository.findByEventID(eventID);
        eventRepository.delete(event);
        return "redirect:/organizerdashboard";
    }
}
