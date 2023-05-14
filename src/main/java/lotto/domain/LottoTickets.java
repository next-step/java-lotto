package lotto.domain;

import lombok.Getter;

import java.util.*;

public class LottoTickets {
    @Getter
    private final List<Ticket> tickets;

    private LottoTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets from(List<Ticket> tickets) {
        return new LottoTickets(tickets);
    }

    public int numberOfTickets() {
        return tickets.size();
    }

    public int totalPrice() {
        return tickets.size() * 1000;
    }

    public boolean checkValidTickets() {
        return tickets.stream().allMatch(Ticket::checkValidTickets);
    }

    public static LottoTickets buyTickets(long money) {
        return LottoGenerator.generateTickets(money);
    }
}
