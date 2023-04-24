package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
    private final Random RANDOM = new Random();
    private final List<Ticket> tickets;

    public Game() {
        this.tickets = new ArrayList<>();
    }

    public void purchaseTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(issueNumbers()));
        }
    }

    private Set<Integer> issueNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size()<6) {
            numbers.add(issueNumber());
        }
        return numbers;
    }

    private int issueNumber() {
        return RANDOM.nextInt(46) + 1;
    }

    public List<String> renderingTickets() {
        List<String> presentTickets = new ArrayList<>();
        for(Ticket ticket : tickets) {
            presentTickets.add(ticket.rendering());
        }
        return presentTickets;
    }

    public Winners makeWinners(Ticket winningTicket) {
        return new Winners(tickets,winningTicket);
    }
}
