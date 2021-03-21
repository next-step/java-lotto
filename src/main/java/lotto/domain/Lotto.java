package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(Integer... numbers) {
        if (numbers.length != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.NUMBER_COUNT_EXCEPTION);
        }
        this.numbers = Arrays.asList(numbers);
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LottoConstant.NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoConstant.NUMBER_COUNT_EXCEPTION);
        }
        this.numbers = numbers;
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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
