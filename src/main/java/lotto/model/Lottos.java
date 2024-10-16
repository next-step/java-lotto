package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final List<Integer> PRIZE_STATIC_VALUES = List.of(5000, 50000, 1500000, 2000000000);
    private static final List<Integer> MATCHING_COUNT_VALUES = List.of(3, 4, 5, 6);

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public void foreach(Consumer consumer) {
        for (Lotto lotto : lottos) {
            consumer.accept(lotto);
        }
    }

    public long match(Lotto winningLotto, long count) {
        return this.lottos.stream()
                .filter((o) -> o.match(winningLotto, count))
                .count();
    }

    public List<Long> calculateMatchingCounts(Lotto lotto) {
        return MATCHING_COUNT_VALUES.stream()
                .map(number -> match(lotto, number))
                .collect(Collectors.toList());
    }

    public long calculateProfit(Lotto winningLotto) {
        return IntStream.range(0, PRIZE_STATIC_VALUES.size())
        .mapToLong(i -> match(winningLotto, MATCHING_COUNT_VALUES.get(i)) * PRIZE_STATIC_VALUES.get(i))
        .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
