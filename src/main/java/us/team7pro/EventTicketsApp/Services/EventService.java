package us.team7pro.EventTicketsApp.Services;

import us.team7pro.EventTicketsApp.Models.Event;

import java.util.List;

public interface EventService {
    // public List<Event> findLatest(int num);
    List<Event> findAll();
    List<Event> findLatest4();
    List<Event> findLatest5();
    Event findByEventID(int eventID);
}
