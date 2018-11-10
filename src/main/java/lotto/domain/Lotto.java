package lotto.domain;

import lotto.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lotto {

    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    private List<Ticket> tickets = new ArrayList<>();

    public int countTicket(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_ONE_LOTTO;
    }

    public List<Ticket> generateTickets(int count) {
        IntStream.range(0, count)
                .mapToObj(i -> new Ticket(Utils.generateRandomNumbers()))
                .forEach(ticket -> this.tickets.add(ticket));

        return this.tickets;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}
