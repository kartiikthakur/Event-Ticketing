package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import us.team7pro.EventTicketsApp.Services.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    private EventService eventService;
    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/admin")
    public String test(Model model) {
        // List<Event> testList = eventService.findAll();
        // for(Event t : testList){
        //     System.out.println(t.getEventID());
        // }
        model.addAttribute("unapprovedEvents", eventRepository.findByStatus(false));
        model.addAttribute("approvedEvents", eventRepository.findByStatus(true));
        model.addAttribute("events", eventRepository.findAll());
        return "admindashboard";
    }

    @PostMapping(value = "/admin")
    public String handleDeleteUser(@RequestParam int del_eventId) throws IOException{
        System.out.println(del_eventId);
        System.out.println("test");
        return "redirect:/admin";
    }

 
    @RequestMapping(value="/approveEvent", method = RequestMethod.GET)
    public String approveEvents(@RequestParam(name="eventID") int eventID) throws IOException{
        Event event = eventRepository.findByEventID(eventID);
        event.setStatus(true);
        eventRepository.save(event);
        return "redirect:/admin";
    }

    @RequestMapping(value="/rejectEvent", method = RequestMethod.GET)
    public String rejectEvents(@RequestParam(name="eventID") int eventID) throws IOException{
        Event event = eventRepository.findByEventID(eventID);
        eventRepository.delete(event);
        return "redirect:/admin";
    }
}
