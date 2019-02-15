package us.team7pro.EventTicketsApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Repositories.EventRepository;
import org.springframework.context.annotation.Primary;
import java.util.*;

@Service
public class EventServiceJpaImpl implements EventService{
    @Autowired
    private EventRepository eventRepo;

    @Override    
    public List<Event> findAll(){
        return this.eventRepo.findAll();
    }

    public List<Event> findLatest(int num){
        List<Event> allEvents = this.eventRepo.findAll();
        Collections.sort(allEvents, new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2){
                return e2.getDate().compareTo(e1.getDate());
            }
        });
        for(int i=allEvents.size()-1; i>=num; i--){
            allEvents.remove(i);
        }
        return allEvents;                
    }

    @Override
    public List<Event> findLatest4(){
        return findLatest(4);
    }

    @Override
    public List<Event> findLatest5(){
        return findLatest(5);
    }
   
    public Event findByEventID(int eventID){
        return this.eventRepo.findByEventID(eventID);
    }
   
    public Event create(Event event){
        return this.eventRepo.save(event);
    }
  
    public Event edit(Event event){
        return this.eventRepo.save(event);
    }

    public void deleteById(int id){
        Event evt = this.findByEventID(id);
        this.eventRepo.delete(evt);
    }
}


