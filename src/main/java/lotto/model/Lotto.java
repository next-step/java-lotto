package lotto.model;

import lotto.exception.InvalidCountOfLottoException;
import lotto.exception.NumbersIsEmptyException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int PRICE_VALUE = 1_000;
    public static final Money PRICE = Money.wons(PRICE_VALUE);
    public static final int SIZE = 6;
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto from(List<Number> numbers) {
        if(numbers == null){
            throw new NumbersIsEmptyException();
        }
        validateLottoSize(numbers);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private static void validateLottoSize(List<Number> numbers) {
        int numbersSize = (int) numbers.stream()
                .distinct()
                .count();
        if (numbersSize != SIZE) {
            throw new InvalidCountOfLottoException(numbersSize);
        }
    }

    public int getMatchCount(Lotto other) {
        return (int) other.numbers.stream()
                .filter(numbers::contains)
                .count();
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

    public boolean hasBonus(Number number) {
        return numbers.contains(number);
    }
}
