package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> tickets;

    public Lottos(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static Lottos generate(int count) {
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
}
