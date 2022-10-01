package com.game.lotto.ticket;

import com.game.lotto.number.RandomLottoNumberGenerator;
import com.game.lotto.ui.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTickets {
    private final List<Ticket> tickets;
    private final Map<Integer, List<Ticket>> ticketsByStrikes;

    public MyTickets(long tryCount) {
        this.tickets = new ArrayList<>();
        this.ticketsByStrikes = new HashMap<>();
        addRandomTicketsByCount(tryCount);
    }

    private void addRandomTicketsByCount(long tryCount) {
        for (int index = 0; index < tryCount; index++) {
            Ticket randomTicket = new Ticket(new RandomLottoNumberGenerator());
            ResultView.printTicketNumbers(randomTicket);
            this.tickets.add(randomTicket);
        }
    }

    public void updateStrikesWithWinnerTicket(Ticket winnerTicket) {
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
