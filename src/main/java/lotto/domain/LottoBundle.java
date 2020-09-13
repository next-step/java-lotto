package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoBundle {

    private List<LottoNumbers> tickets;

    public LottoBundle() {
        this.tickets = new ArrayList<>();
    }

    public LottoBundle(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(List<LottoNumbers> numbers) {
        tickets.addAll(numbers);
    }

    public LottoResult drawing(WinningLotto winningLotto) {
        return tickets.stream()
                .map(winningLotto::matching)
                .collect(collectingAndThen(toList(), LottoResult::new));
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBundle that = (LottoBundle) o;
        return tickets.equals(that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
