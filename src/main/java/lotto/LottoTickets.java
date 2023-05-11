package lotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    List<Ticket> tickets = new ArrayList<>();
    int[] counter = new int[7];

    public LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public LottoTickets(String price) {
        int numberOfTickets = Integer.parseInt(price) / 1000;
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

    public boolean checkValidTickets() {
        return tickets.stream().allMatch(Ticket::checkValidTickets);
    }

    public void countMatchingTickets(List<Integer> winningNumber) {
        tickets.stream().forEach(t -> counter[t.numberOfMatching(winningNumber)]++);
    }

    public int getCountOfMatchingNumber(int number) {
        return counter[number];
    }
}
