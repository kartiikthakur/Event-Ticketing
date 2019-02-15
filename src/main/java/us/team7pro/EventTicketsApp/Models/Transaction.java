package us.team7pro.EventTicketsApp.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionID;
    private long userID;
    private String userName;
    private int eventID;
    private String eventName;
    private boolean status;  // purchased or not

    public Transaction() {}


    public Transaction(long userID, String userName, int eventID, String eventName) {
        this.userID = userID;
        this.userName = userName;
        this.eventID = eventID;
        this.eventName = eventName;
    }
}
