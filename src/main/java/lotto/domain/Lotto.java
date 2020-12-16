package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Collections.sort;

public class Lotto {
    private static final String NUMBER_DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        sort(numbers);
        this.numbers = numbers;
    }

    public Lotto(String winNumbers) {
        String[] split = winNumbers.split(NUMBER_DELIMITER);
        this.numbers = Arrays.stream(split)
                .map(it -> {
                    try {
                        return Integer.parseInt(it);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("숫자만 입력해 주세요.");
                    }
                }).sorted()
                .collect(Collectors.toList());
    }

    public int matchNumberCnt(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.numbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(NUMBER_DELIMITER));
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
        return numbers != null ? numbers.hashCode() : 0;
    }
}
