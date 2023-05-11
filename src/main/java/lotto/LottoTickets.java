package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    List<Ticket> tickets = new ArrayList<>();

    private LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets);
    }

    public LottoTickets(String price) {
        generateTickets(Integer.parseInt(price) / 1000);
    }

    public static LottoTickets from(String price) {
        return new LottoTickets(price);
    }

    private void generateTickets(int numberOfTickets) {
        List<Integer> candidateNumbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        IntStream.range(0, numberOfTickets)
                .forEach(i -> {
                    Collections.shuffle(candidateNumbers);
                    tickets.add(Ticket.from(candidateNumbers));
                });
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

    public int[] counterOfMatchingTickets(List<Integer> winningNumber) {
        int[] counter = new int[7];
        tickets.stream().forEach(t -> counter[t.numberOfMatching(winningNumber)]++);
        return counter;
    }
}
