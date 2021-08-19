package edu.nextstep.lottoauto.domain;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public void saveAll(List<Ticket> createdTickets) {
        tickets.addAll(createdTickets);
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }
}
