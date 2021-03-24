package lotto.step2.domain;

import lotto.step2.utils.LottoUtils;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;


public class Lotto {

    private Set<Integer> numbers;

    private Lotto(final Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto of(final Set<Integer> numbers) {
        LottoUtils.validation(numbers);
        return new Lotto(numbers);
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
