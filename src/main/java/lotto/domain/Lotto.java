package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.settings.LottoSettings;

public class Lotto {

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        if (hasIncorrectSize(numbers) || hasDuplicates(numbers)) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
        this.numbers = toLottoNumber(numbers);
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private boolean hasIncorrectSize(List<Integer> numbers) {
        return !LottoSettings.isValidSize(numbers.size());
    }

    private List<LottoNumber> toLottoNumber(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::of).collect(Collectors.toList());
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
        return (int) winning.numbers.stream().filter(this::containNumber).count();
    }

    public boolean containNumber(LottoNumber number) {
        return this.numbers.contains(number);
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
        List<LottoNumber> sortNumbers = numbers.stream().sorted().collect(Collectors.toList());

        return sortNumbers.toString();
    }
}
