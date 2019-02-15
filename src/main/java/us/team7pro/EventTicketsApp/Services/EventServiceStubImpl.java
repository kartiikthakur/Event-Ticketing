// package us.team7pro.EventTicketsApp.Services;

// import org.springframework.stereotype.Service;
// import us.team7pro.EventTicketsApp.Models.Event;
// import org.springframework.context.annotation.Primary;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Objects;
// import java.util.stream.Collectors;

// /**
//  * This class is just for testing
//  */
// @Service
// @Primary
// public class EventServiceStubImpl implements EventService {
//     private List<Event> events = new LinkedList<>();

// //    public EventServiceStubImpl() {
// //        events.add(new Event(1, "Event Dummy 1", "Concerts", "Albany"));
// //        events.add(new Event(2, "Event Dummy 2", "Sports", "Canada"));
// //        events.add(new Event(3, "Event Dummy 3", "Festival", "Troy"));
// //        events.add(new Event(6, "Event Dummy 6", "Concerts", "New Jersey"));
// //        events.add(new Event(5, "Event Dummy 5", "Theater", "Queens"));
// //        events.add(new Event(4, "Event Dummy 4", "Concerts", "Long Island"));
// //    }


//     @Override
//     public List<Event> findAll() {
//         return this.events;
//     }

//     @Override
//     public List<Event> findLatest4() {
//         return this.events.stream()
//                 .sorted((a,b)->b.getEventCategory().compareTo(a.getEventCategory()))
//                 .limit(4).collect(Collectors.toList());
//     }

//     @Override
//     public List<Event> findLatest5() {
//         return this.events.stream()
//                 .sorted((a,b)->b.getEventCategory().compareTo(a.getEventCategory()))
//                 .limit(5).collect(Collectors.toList());
//     }
   
//     @Override
//     public Event findByEventID(int eventID) {
//         return this.events.stream().filter(e-> Objects.equals(e.getEventID(), eventID))
//                 .findFirst().orElse(null);
//     }
// }
