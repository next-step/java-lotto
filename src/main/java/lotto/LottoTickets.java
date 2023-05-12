package lotto;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    @Getter
    private List<Ticket> tickets = new ArrayList<>();

    private LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private LottoTickets(int price) {
        generateTickets(price / 1000);
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets);
    }

    public static LottoTickets from(int price) {
        return new LottoTickets(price);
    }

    private void generateTickets(int numberOfTickets) {
        for(int i = 0; i < numberOfTickets; i++) {
            List<Integer> candidateNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
            Collections.shuffle(candidateNumbers);
            Ticket newTicket = Ticket.from(candidateNumbers.subList(0, 6));
            tickets.add(newTicket);
        }
    }

    public int getNumberOfTickets() {
        return tickets.size();
    }

    public int totalPrice() {
        return tickets.size() * 1000;
    }

    public boolean checkValidTickets() {
        return tickets.stream().allMatch(Ticket::checkValidTickets);
    }

    public int[] counterOfMatchingTickets(WinningNumber winningNumber) {
        int[] counter = new int[7];
        tickets.stream().forEach(t -> counter[t.numberOfMatching(winningNumber.getWinningNumber())]++);
        return counter;
    }
}
