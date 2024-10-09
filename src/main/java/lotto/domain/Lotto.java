package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static int LOTTO_NUMBERS_CARDINALITY = 6;
    private static int MIN_BOUND = 1;
    private static int MAX_BOUND = 45;
    private static String DUPLICATED_LOTTO_NUMBERS_MESSAGE = "중복된 숫자가 존재합니다.";
    private static String INVALID_LOTTO_NUMBERS_CARDINALITY_MESSAGE = "로또 숫자 갯수가 다릅니다.";
    private static String LOTTO_NUMBER_IS_OUT_OF_RANGE_MESSAGE = "로또 숫자가 범위 밖입니다.";
    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto valueOf(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_CARDINALITY) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBERS_CARDINALITY_MESSAGE);
        }
        for (int number : numbers) {
            if (number < MIN_BOUND || number > MAX_BOUND) {
                throw new IllegalArgumentException(LOTTO_NUMBER_IS_OUT_OF_RANGE_MESSAGE);
            }
        }
        Set<Integer> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_MESSAGE);
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
