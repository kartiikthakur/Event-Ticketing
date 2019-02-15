package us.team7pro.EventTicketsApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Services.EventService;

import java.util.List;

@Controller
public class ComingEventsController {
    @Autowired
    private EventService eventService;

    @RequestMapping("/test")
    public String test(Model model) {
        List<Event> testList = eventService.findLatest4();
        model.addAttribute("testlist", testList);
        return "testpage";
    }
}
