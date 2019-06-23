package lotto.model;

import lotto.exception.InvalidCountOfLottoException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money PRICE = Money.wons(1000);
    public static final int SIZE = 6;
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        numbers = removeDuplicateNumbers(numbers);
        if (numbers.size() != SIZE) {
            throw new InvalidCountOfLottoException(numbers.size());
        }
        return new Lotto(numbers);
    }

    private static List<Number> removeDuplicateNumbers(List<Number> numbers) {
        numbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return numbers;
    }

    public int getMatchCount(Lotto other) {
        return (int) other.numbers.stream()
                .filter(number -> numbers.contains(number))
                .count();
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
    public String
    toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
