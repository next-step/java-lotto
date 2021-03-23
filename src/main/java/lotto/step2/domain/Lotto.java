package lotto.step2.domain;

import lotto.step2.exception.LottoException;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;


public class Lotto {

    private static final String LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS = "로또는 6개의 숫자로 이루어져야 합니다.";
    private static final int LOTTO_MADE_OF_NUMBERS = 6;
    private Set<Integer> numbers = new TreeSet<>();

    private Lotto(final Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final Set<Integer> numbers) {
        validation(numbers);
        return new Lotto(numbers);
    }

    private static void validation(final Set<Integer> numbers) {
        if (numbers.size() != LOTTO_MADE_OF_NUMBERS) {
            throw new LottoException(LOTTO_NUMBERS_MADE_OF_SIX_NUMBERS);
        }
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
