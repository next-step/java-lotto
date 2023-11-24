package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static Lottos issue(int money) {
        int ticketCount = Lotto.calculateTicketCount(money);
        return generate(ticketCount);
    }

    private static Lottos generate(int count) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new Lotto());
        }
        return new Lottos(tickets);
    }

    public int count() {
        return this.tickets.size();
    }

    public List<Lotto> tickets() {
        return this.tickets;
    }

    public List<Integer> matchNumbers(LottoNumbers winningNumber) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));
        for (Lotto ticket : this.tickets) {
            int matchCount = ticket.numbers().matchNumbers(winningNumber);
            result.set(matchCount, result.get(matchCount) + 1);
        }
        return result;
    }
}
