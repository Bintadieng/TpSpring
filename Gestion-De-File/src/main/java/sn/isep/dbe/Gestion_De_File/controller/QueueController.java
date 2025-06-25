package sn.isep.dbe.Gestion_De_File.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.isep.dbe.Gestion_De_File.model.Ticket;
import sn.isep.dbe.Gestion_De_File.service.QueueService;

import java.util.Queue;

@RestController
@RequestMapping("/api/queue")
public class QueueController {
    private final QueueService queueService;

    @Autowired
    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @PostMapping("/ticket")
    public Ticket generateTicket() {
        return queueService.generateTicket();
    }

    @GetMapping("/tickets")
    public Queue<Ticket> getAllTickets() {
        return queueService.getAllTickets();
    }

    @PostMapping("/process")
    public Ticket processNext() {
        return queueService.processNext();
    }

    @PutMapping("/move-back/{ticketNumber}")
    public void moveBack(@PathVariable int ticketNumber) {
        queueService.moveBack(ticketNumber);
    }
}