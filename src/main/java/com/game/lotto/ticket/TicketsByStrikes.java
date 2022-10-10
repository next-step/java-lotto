package com.game.lotto.ticket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketsByStrikes {
    private final Map<Integer, List<Ticket>> ticketsByStrikes;

    public TicketsByStrikes(Ticket winnerTicket, final List<Ticket> tickets) {
        this.ticketsByStrikes = new HashMap<>();
        updateStrikesWithWinnerTicket(winnerTicket, tickets);
    }

    private void updateStrikesWithWinnerTicket(Ticket winnerTicket, List<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            int strikes = ticket.compareWinnerNumbersAndGetStrikes(winnerTicket);
            addTicketsByStrikes(strikes, ticket);
        }
    }

    public List<Ticket> getTicketsByStrikes(int strikes) {
        return ticketsByStrikes.getOrDefault(strikes, new ArrayList<>());
    }

    private void addTicketsByStrikes(int strikes, Ticket ticket) {
        if (ticketsByStrikes.containsKey(strikes)) {
            ticketsByStrikes.get(strikes).add(ticket);
            return;
        }
        ticketsByStrikes.put(strikes, new ArrayList<>());
        ticketsByStrikes.get(strikes).add(ticket);
    }
}
