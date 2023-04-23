package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Match {
    private final Random RANDOM = new Random();
    private final List<Ticket> tickets;
    private Winners winners = null;

    public Match() {
        this.tickets = new ArrayList<>();
    }

    public void purchase(int count) {
        for (int i = 0; i < count; i++) {
            addTicket(new Ticket(issuance()));
        }
    }

    private Set<Integer> issuance() {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(RANDOM.nextInt(46));
        }
        return numbers;
    }

    private void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public List<String> renderingTickets() {
        List<String> presentTickets = new ArrayList<>();
        for(Ticket ticket : tickets) {
            presentTickets.add(ticket.rendering());
        }
        return presentTickets;
    }

    public void winningTicket(Ticket winningTicket) {
        winners = new Winners(tickets,winningTicket);
    }


    public Winners getWinners() {
        if(winners == null) {
            throw new RuntimeException("위너가 계산되지 읺았거나, 당첨번호가 입력되지 않았습니다");
        }
        return winners;
    }

    public double returnRate() {
        throw new RuntimeException();
    }
}
