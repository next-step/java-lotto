package lotto.model;

import lotto.exception.InvalidCountOfLottoException;
import lotto.exception.NumbersIsEmptyException;

import java.util.*;
import java.util.function.LongFunction;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lotto {

    public static final String SEPARATOR_OF_LOTTO_NUMBERS = ",";
    public static final int SIZE = 6;

    static final Money PRICE = Money.won(1_000);

    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto from(List<Number> numbers) {
        if (numbers == null) {
            throw new NumbersIsEmptyException();
        }
        validateLottoSize(numbers);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public static Lotto ofComma(String numbers) {
        return Arrays.stream(numbers.split(SEPARATOR_OF_LOTTO_NUMBERS))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::of)
                .collect(collectingAndThen(toList(), Lotto::from));
    }

    private static void validateLottoSize(List<Number> numbers) {
        int numbersSize = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersSize != SIZE) {
            throw new InvalidCountOfLottoException(numbersSize);
        }
    }

    int getMatchCount(Lotto other) {
        return (int) other.numbers.stream()
                .filter(numbers::contains)
                .count();
    }

    boolean hasBonusNumber(Number number) {
        return numbers.contains(number);
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
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
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}