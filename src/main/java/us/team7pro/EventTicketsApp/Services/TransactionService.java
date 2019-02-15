package us.team7pro.EventTicketsApp.Services;

import us.team7pro.EventTicketsApp.Models.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> findByUserID(long userID);
    List<Transaction> findByUserIDAndStatus(long userID, boolean status);
    Transaction findByUserIDAndEventID(long userID, int eventID);
    Transaction findByTransactionID(int transactionID);
    void delete(Transaction t);
    void addToCart(long userID, int eventID);
    void deleteAll();
}
