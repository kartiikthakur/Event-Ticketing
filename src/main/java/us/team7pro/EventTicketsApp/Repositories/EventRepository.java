package us.team7pro.EventTicketsApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Models.Event;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    public List<String> findByEventCategory(String eventCategory);
    public List<String> findByOrganizerID(Long organizerID);
    public List<String> findByStatus(boolean status);
    public Event findByEventID(int eventID);
    public List<Event> findByLocationContaining(String location);
    public List<Event> findByEventNameContaining(String location);
    public List<Event> findByEventNameContainingOrLocationContaining(String eventName, String location);
}
