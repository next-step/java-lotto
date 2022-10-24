package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private final Set<Number> numbers;

    public Lotto(Set<Number> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("로또의 숫자 갯수는 6개 입니다.");
        }
    }

    public static Lotto create(final LottoNumberStrategy lottoNumberStrategy) {
        return new Lotto(lottoNumberStrategy.provideNumberSet());
    }

    public Rank checkRank(WinnerNumbers winnerNumbers) {
        return Rank.valueOf(winnerNumbers.match(numbers), winnerNumbers.hasBonus(numbers));
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
