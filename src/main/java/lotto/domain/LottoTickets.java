package lotto.domain;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Ticket.MAX_LOTTO_NUMBER;
import static lotto.domain.Ticket.MIN_LOTTO_NUMBER;

public class LottoTickets {
    public static final int LOTTO_PRICE = 1000;

    @Getter
    private List<Ticket> tickets = new ArrayList<>();

    private LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    private LottoTickets(int price) {
        generateTickets(price / LOTTO_PRICE);
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets);
    }

    public static LottoTickets from(int price) {
        return new LottoTickets(price);
    }

    private void generateTickets(int numberOfTickets) {
        for(int i = 0; i < numberOfTickets; i++) {
            List<Integer> candidateNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());
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
