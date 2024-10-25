package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (hasInvalidNumber(numbers) || hasIncorrectSize(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
        this.numbers = numbers;
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasIncorrectSize(List<Integer> numbers) {
        return !LottoSettings.isValidSize(numbers.size());
    }

    private boolean hasInvalidNumber(List<Integer> numbers) {
        return numbers.stream().anyMatch(i -> !LottoSettings.isNumberInValidRange(i));
    }

    public static Lotto from(String value) {
        return new Lotto(toNumbers(split(value)));
    }

    private static String[] split(String value) {
        return value.split(",");
    }

    private static List<Integer> toNumbers(String[] value) {
        return Arrays.stream(value).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int matchCount(Lotto winning) {
        return (int) numbers.stream().filter(winning.numbers::contains).count();
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
        return numbers.toString();
    }
}
