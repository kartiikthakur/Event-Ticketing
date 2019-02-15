package us.team7pro.EventTicketsApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Models.Transaction;
import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import us.team7pro.EventTicketsApp.Repositories.TransactionRepository;
import us.team7pro.EventTicketsApp.Repositories.UserRepository;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    TransactionRepository transactionRepository;
//
//    @GetMapping("/admindashboard")
//    public String admindashboard() {
//        return "admindashboard";
//    }
//
   @GetMapping("/userdashboard")
   public String userdashboard(Model model, @AuthenticationPrincipal User user) {
       model.addAttribute("transactions", transactionRepository.findByUserID(user.getId()));
       model.addAttribute("events", eventRepository.findAll());
       return "userdashboard";
   }

    // @RequestMapping("/purchaseTicket")
    // public String purchaseTicket(@RequestParam int eventID, @RequestParam int userID) {
    //     if (transactionRepository.findByUserIDAndEventID(userID, eventID) == null) {
    //         User usr = userRepository.findByUserID(userID);
    //         Event evt = eventRepository.findByEventID(eventID);
    //         Transaction t = new Transaction(usr.getUserID(), usr.getUserName(), evt.getEventID(), evt.getEventName());
    //         transactionRepository.save(t);
    //     }
    //     return "redirect:/./userdashboard";
    // }

    @RequestMapping("/cancelTicket")
    public String cancelTicket(@RequestParam int transactionID, @AuthenticationPrincipal User user) {
        Transaction t = transactionRepository.findByTransactionID(transactionID);
        if (t != null) {
            transactionRepository.delete(t);
        }
        return "redirect:/./userdashboard";
    }

    @GetMapping("/signup")
    public String userSignUp(Model model){
        model.addAttribute("newUser", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String userSubmit(@ModelAttribute User newUser){
        User dbUser = userRepository.findByEmail(newUser.getEmail());
        if(dbUser == null){
            //newUser.setRole("User");
            userRepository.save(newUser);
            return "success/signupSuccess";
        } else {
            return "errors/userExistError";
        }

    }


//    @GetMapping("/signin")
//    public String userSignIn(Model model){
//        model.addAttribute("visitor", new User());
//        return "signin";
//    }
//
//    @PostMapping("/signin")
//    public String userSignInResult(@ModelAttribute User visitor){
//        User dbUser = userRepository.findByEmail(visitor.getEmail());
//        if(dbUser==null || !dbUser.getPassword().equals(visitor.getPassword())){
//            return "errors/signinError";
//        }  else {
//            if(dbUser.getRole().equals("Admin")){
//                return "admindashboard";
//            } else if (dbUser.getRole().equals("Organizer")){
//                return "organizerdashboard";
//            } else {
//                return "success/signinSuccess";
//            }
//
//        }
//
//    }

//    @GetMapping("/logout")
//    public String userLogout(){
//        return "success/logoutSuccess";
//    }

    
}
