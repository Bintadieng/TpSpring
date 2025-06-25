package sn.isep.dbe.Gestion_De_File.repository;


import org.springframework.stereotype.Repository;
import sn.isep.dbe.Gestion_De_File.model.Ticket;

import java.util.LinkedList;
import java.util.Queue;

@Repository
public class QueueRepository {
    private final Queue<Ticket> queue = new LinkedList<>();
    private int currentNumber = 1;

    public Ticket generateTicket() {
        Ticket ticket = new Ticket(currentNumber++, queue.size());
        queue.add(ticket);
        return ticket;
    }

    public Queue<Ticket> getAllTickets() {
        return new LinkedList<>(queue);
    }

    public Ticket processNext() {
        return queue.poll();
    }

    public void moveBack(Ticket ticket) {
        queue.add(ticket);
    }
}