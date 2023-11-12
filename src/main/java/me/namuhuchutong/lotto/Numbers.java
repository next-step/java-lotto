package me.namuhuchutong.lotto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Numbers {

    private final List<Number> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        return new Numbers(numberGenerator.createNumbers());
    }

    public Numbers(List<Number> values) {
        validateSixNumbers(values);
        validateDuplicatedNumbers(values);
        this.values = values;
    }

    private void validateSixNumbers(List<Number> values) {
        if (values.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개여야 합니다.");
        }
    }

    private void validateDuplicatedNumbers(List<Number> values) {
        values.stream()
              .filter(number -> Collections.frequency(values, number) > 1)
              .findAny()
              .ifPresent(value -> {
                  throw new IllegalArgumentException("중복된 값이 존재합니다. - " + value);
              });
    }

    public int size() {
        return this.values.size();
    }

    public long howManyMatch(Numbers numbers) {
        return this.values.stream()
                          .filter(number1 -> numbers.values.stream()
                                                            .anyMatch(number1::equals))
                          .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return values.equals(numbers.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
