package edu.nextstep.lottoauto.repository;

import edu.nextstep.lottoauto.domain.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<Ticket> findAll() {
        return tickets;
    }
}
