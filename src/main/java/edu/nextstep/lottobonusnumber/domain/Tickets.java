package edu.nextstep.lottobonusnumber.domain;

import edu.nextstep.lottobonusnumber.domain.numbersmaker.NumbersMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Tickets of(Payment payment, NumbersMaker numbersMaker) {
        int countOfTickets = payment.countOfTickets();

        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < countOfTickets; i++) {
            Ticket ticket = Ticket.madeBy(numbersMaker);
            tickets.add(ticket);
        }

        return new Tickets(tickets);
    }

    public Stream<Ticket> stream() {
        return tickets.stream();
    }

    public Map<Prize, Integer> checkWinningResult(Ticket winningTicket, BonusNumber bonusNumber) {
        return null;
    }
}
