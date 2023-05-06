package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public Tickets() {
        this.tickets = new ArrayList<>();
    }

    public static Tickets emptyTickets() {
        return new Tickets(new ArrayList<>());
    }

    public static Tickets automaticIssue(int ticketCount) {
        Tickets autoTickets = new Tickets();
        for (int i = 0; i < ticketCount; i++) {
            autoTickets.add(Ticket.auto());
        }
        return autoTickets;
    }

    public static Tickets composite(Tickets firstTicket, Tickets lastTicket) {
        Tickets compositeTicket = new Tickets(firstTicket.allTickets());
        compositeTicket.add(lastTicket);
        return compositeTicket;
    }

    public int count() {
        return tickets.size();
    }

    public void add(Ticket ticket) {
        this.tickets.add(ticket);
    }

    public void add(Tickets tickets) {
        this.tickets.addAll(tickets.allTickets());
    }

    public List<Ticket> allTickets() {
        return new ArrayList<>(tickets);
    }
}
