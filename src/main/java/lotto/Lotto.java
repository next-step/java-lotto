package lotto;

import java.util.*;

public class Lotto {

    private final Set<Number> numbers;

    public Lotto(Set<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto create(final LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.provideNumberSet());
    }

    public Rank checkRank(Set<Number> winnersNumber) {
        return Rank.valueOf(match(winnersNumber));
    }

    private int match(Set<Number> winnersNumber) {
        List<Number> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(winnersNumber);
        return numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
