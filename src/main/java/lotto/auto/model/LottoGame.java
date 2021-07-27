package lotto.auto.model;

import java.util.Iterator;
import java.util.List;

public class LottoGame {
    private final List<Integer> tickets;

    private LottoGame(List<Integer> tickets) {
        this.tickets = tickets;
    }

    public static LottoGame from(List<Integer> tickets) {
        return new LottoGame(tickets);
    }

    public Iterator<Integer> iterator() {
        return tickets.iterator();
    }

    public int size(){
        return tickets.size();
    }

    @Override
    public String toString() {
        return tickets.toString();
    }
}
