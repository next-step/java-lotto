package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static Lottos generate(List<LottoNumbers> ticketsNumbers) {
        return new Lottos(ticketsNumbers.stream()
                        .map(Lotto::new)
                        .collect(Collectors.toList()));
    }

    public static Lottos combine(Lottos lottos1, Lottos lottos2) {
        return new Lottos(
                Stream.concat(lottos1.tickets().stream(), lottos2.tickets().stream())
                        .collect(Collectors.toList()));
    }

    public int count() {
        return this.tickets.size();
    }

    public List<Lotto> tickets() {
        return this.tickets;
    }
}
