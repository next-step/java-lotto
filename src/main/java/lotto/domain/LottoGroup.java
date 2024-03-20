package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoGroup {
    private final NumbersGenerator generator;
    private final List<List<Integer>> tickets = new ArrayList<>();

    public LottoGroup(NumbersGenerator generator) {
        this.generator = generator;
    }

    public void generateTickets(Cash cash) {
        for (int i = 0; i < cash.getAmount(); i++) {
            tickets.add(generator.generate());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGroup)) return false;
        LottoGroup that = (LottoGroup) o;
        return Objects.equals(generator, that.generator) && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generator, tickets);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> ticket : this.tickets) {
            sb.append(ticket);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
