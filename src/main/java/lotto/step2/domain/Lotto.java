package lotto.step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    private Lotto(final int[] numbers) {
        for (int number : numbers) {
            this.numbers.add(number);
        }
    }

    public static Lotto of(final int[] numbers) {
        return new Lotto(numbers);
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
