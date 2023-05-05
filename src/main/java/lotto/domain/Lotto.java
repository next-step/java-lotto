package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private List<Number> numbers;

    public Lotto(String numbers) {
        this.numbers = split1(numbers);
        validate1(this.numbers);
    }

    private void validate1(List<Number> numbers1) {
        if (numbers1.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("개수가 6개가 아닙니다.");
        }
    }

    private List<Number> split1(String numbers) {
        String[] number = numbers.split(", ");
        return Arrays.stream(number).map(num -> new Number(Integer.parseInt(num))).collect(Collectors.toList());
    }

    public int matchesNumber(Lotto lotto) {
        return numbers.stream()
                .filter(number -> lotto.numbers
                        .stream()
                        .anyMatch(Predicate.isEqual(number)))
                .collect(Collectors.toList())
                .size();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[","]"));
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
}
