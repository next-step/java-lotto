package edu.nextstep.lottoauto.domain;

import java.util.ArrayList;
import java.util.List;

public class TicketRepository {

    private static final List<Ticket> tickets = new ArrayList<>();

    public static void save(Ticket ticket) {
        tickets.add(ticket);
    }

    public static void saveAll(List<Ticket> createdTickets) {
        tickets.addAll(createdTickets);
    }

    public static List<Ticket> findAll() {
        return tickets;
    }

    public static void removeAll() {
        tickets.clear();
    }
}
