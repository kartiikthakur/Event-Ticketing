package us.team7pro.EventTicketsApp.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.team7pro.EventTicketsApp.Models.Event;
import us.team7pro.EventTicketsApp.Models.Transaction;
import us.team7pro.EventTicketsApp.Domain.User;
import us.team7pro.EventTicketsApp.Repositories.TransactionRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TransactionServiceJpaImpl implements TransactionService{
    @Autowired
    private TransactionRepository transRepo;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Override
    public List<Transaction> findByUserID(long userID) {
        return transRepo.findAll().stream()
                .filter(t -> Objects.equals(t.getUserID(), userID))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> findByUserIDAndStatus(long userID, boolean status) {
        return transRepo.findByUserIDAndStatus(userID, status);
    }

    @Override
    public Transaction findByUserIDAndEventID(long userID, int eventID) {
        return null;
    }

    @Override
    public Transaction findByTransactionID(int transactionID) {
        return transRepo.findByTransactionID(transactionID);
    }

    @Override
    public void delete(Transaction t) {
        transRepo.delete(t);
    }

    @Override
    public void deleteAll() {
        transRepo.deleteAll();
    }

    @Override
    public void addToCart(long userID, int eventID) {
        Event e = eventService.findByEventID(eventID);
        User u = userService.findById(userID);
        Transaction transaction = new Transaction(u.getId(), u.getEmail(), e.getEventID(), e.getEventName());
        transRepo.save(transaction);
    }
}
