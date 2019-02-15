package us.team7pro.EventTicketsApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import us.team7pro.EventTicketsApp.Models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    public List<Transaction> findByUserID(long userID);
    public List<Transaction> findByUserIDAndStatus(long userID, boolean status);
    public Transaction findByUserIDAndEventID(long userID, int eventID);
    public Transaction findByTransactionID(int transactionID);
}
