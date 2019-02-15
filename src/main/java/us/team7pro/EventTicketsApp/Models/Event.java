package us.team7pro.EventTicketsApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name="events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eventID;
    private long organizerID;
    private String eventName;
    private String eventCategory; // Concerts, Sports, Festivals
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date date;
    private String location;
    private String description;
    private float price;
    private String imgUrl;
    private boolean status;  // approved or not

    public Event() {}

    public Event(long organizerID, String eventName, String eventCategory, String location, Date date, String description, float price, String imgUrl, boolean status) {
        this.organizerID = organizerID;
        this.eventName = eventName;
        this.eventCategory = eventCategory;
        this.location = location;
        this.date = date;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.status = status;
    }
}
