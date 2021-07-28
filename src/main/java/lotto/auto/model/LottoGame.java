package lotto.auto.model;

import java.util.List;
import java.util.Objects;

public class LottoGame {
    private final List<Integer> tickets;

    private LottoGame(final List<Integer> tickets) {
        this.tickets = tickets;
    }

    public static LottoGame from(final List<Integer> tickets) {
        Objects.requireNonNull(tickets);
        return new LottoGame(tickets);
    }

    public boolean contains(int number) {
        return tickets.contains(number);
    }

    public int size() {
        return tickets.size();
    }

    @Override
    public String toString() {
        return tickets.toString();
    }
}
