package lotto.domain;

import lotto.util.TotalNumbers;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.util.Price.LOTTO_PRICE;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(Amount amount) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < amount.divide(LOTTO_PRICE); i++) {
            Collections.shuffle(TotalNumbers.NUMBERS);
            result.add(new Lotto(TotalNumbers.NUMBERS.subList(0, 6)
                            .stream()
                            .sorted(Comparator.comparingInt(Number::value))
                            .collect(Collectors.toList())
            ));
        }
        return new Lottos(result);
    }

    public List<Lotto> values() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Amount totalAmount() {
        return new Amount(LOTTO_PRICE.multiply(lottos.size()));
    }

    public boolean isAllValidRange() {
        return lottos.stream().allMatch(Lotto::isValidRange);
    }

    public boolean isAllSorted() {
        return lottos.stream().allMatch(Lotto::isSorted);
    }

    public Lottos merged(Lottos other) {
        List<Lotto> merged = new ArrayList<>(this.lottos);
        merged.addAll(other.lottos);
        return new Lottos(merged);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottos);
    }
}
