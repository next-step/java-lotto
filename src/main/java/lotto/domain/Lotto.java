package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private static int LOTTO_NUMBERS_CARDINALITY = 6;
    private static String INVALID_LOTTO_NUMBERS_CARDINALITY_MESSAGE = "로또 숫자 갯수가 다릅니다.";
    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto valueOf(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_CARDINALITY) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_CARDINALITY_MESSAGE);
        }
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
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
        return Objects.hashCode(numbers);
    }
}
