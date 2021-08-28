package edu.nextstep.lottocustom.domain;

import edu.nextstep.lottocustom.domain.numbersmaker.NumbersMaker;

import java.util.*;
import java.util.stream.Stream;

public class Tickets {
    private final List<Ticket> tickets;

    private Tickets(List<Ticket> tickets) {
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

    public Map<Prize, Integer> checkWinningResult(WinningTicket winningTicket) {
        Map<Prize, Integer> winningResult = createAndInitWinningResult();

        for (Ticket ticket : tickets) {
            Prize prize = winningTicket.checkPrize(ticket);
            winningResult.put(prize, winningResult.getOrDefault(prize, 0)+1);
        }

        return winningResult;
    }

    private Map<Prize, Integer> createAndInitWinningResult() {
        Map<Prize, Integer> winningResult = new LinkedHashMap<>();

        Arrays.stream(Prize.values())
                .forEach(prize -> winningResult.put(prize, winningResult.getOrDefault(prize, 0)));

        return winningResult;
    }

    public int count(){
        return tickets.size();
    }
}
