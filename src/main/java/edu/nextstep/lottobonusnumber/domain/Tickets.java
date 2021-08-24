package edu.nextstep.lottobonusnumber.domain;

import java.util.*;
import java.util.stream.Stream;

public class Tickets {

    private final List<Ticket> tickets;

    private Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Tickets of(List<Ticket> tickets) {
        return new Tickets(tickets);
    }

    public int calculatePayment() {
        return tickets.size() * TicketMachine.TICKET_PRICE;
    }

    public Stream<Ticket> stream() {
        return tickets.stream();
    }
}
