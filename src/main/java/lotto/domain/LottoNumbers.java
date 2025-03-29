package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoNumbers {
    private final int LOTTO_NUMBER_SIZE = 6;
    private final String DELIMITER = ",";

    private final List<Number> numbers;

    public LottoNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public LottoNumbers(String input) {
        if (!validate(input)) {
            throw new IllegalArgumentException();
        }
        this.numbers = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .sorted()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    private boolean validate(String input) {
        return validSize(input) && uniqueNumbers(input);
    }

    private boolean validSize(String input) {
        return input.split(DELIMITER).length == LOTTO_NUMBER_SIZE;
    }

    private boolean uniqueNumbers(String input) {
        return new HashSet<>(List.of(input.split(DELIMITER))).size() == LOTTO_NUMBER_SIZE;
    }

    public List<Number> values() {
        return numbers;
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public boolean isValidRange() {
        return numbers.stream().allMatch(Number::isValidRange);
    }

    public boolean isSorted() {
        return IntStream.range(0, numbers.size()-1)
                .allMatch(i -> numbers.get(i).isSmallerThan(numbers.get(i+1)));
    }

    public Stream<Number> stream() {
        return numbers.stream();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_NUMBER_SIZE, DELIMITER, numbers);
    }
}
