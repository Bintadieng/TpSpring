package sn.isep.dbe.Gestion_De_File.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.isep.dbe.Gestion_De_File.model.Ticket;
import sn.isep.dbe.Gestion_De_File.repository.QueueRepository;

import java.util.Queue;

@Service
public class QueueService {
    private final QueueRepository queueRepository;

    @Autowired
    public QueueService(QueueRepository queueRepository) {
        this.queueRepository = queueRepository;
    }

    public Ticket generateTicket() {
        return queueRepository.generateTicket();
    }

    public Queue<Ticket> getAllTickets() {
        return queueRepository.getAllTickets();
    }

    public Ticket processNext() {
        return queueRepository.processNext();
    }

    public void moveBack(int ticketNumber) {
        Queue<Ticket> tickets = queueRepository.getAllTickets();
        Ticket ticketToMove = tickets.stream()
                .filter(t -> t.getNumber() == ticketNumber)
                .findFirst()
                .orElse(null);

        if (ticketToMove != null) {
            tickets.remove(ticketToMove);
            queueRepository.moveBack(ticketToMove);
        }
    }
}