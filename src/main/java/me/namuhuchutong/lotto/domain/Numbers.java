package me.namuhuchutong.lotto.domain;

import java.util.Objects;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import me.namuhuchutong.lotto.domain.generator.NumberGenerator;

public class Numbers {

    private final List<Number> values;

    public static Numbers create(NumberGenerator numberGenerator) {
        return new Numbers(numberGenerator.createNumbers());
    }

    public static Numbers create(String manualNumbers) {
        List<Number> collect = Arrays.stream(manualNumbers.split(",\\s*"))
                                     .map(Integer::valueOf)
                                     .map(Number::new)
                                     .collect(Collectors.toList());
        return new Numbers(collect);
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
        int setSize = new HashSet<>(values).size();
        int valuesSize = values.size();
        if (setSize != valuesSize) {
            throw new IllegalArgumentException("중복된 값이 존재합니다. - " + values);
        }
    }

    public int size() {
        return this.values.size();
    }

    public long howManyMatch(Numbers numbers) {
        Set<Number> numberSet = new HashSet<>(numbers.values);
        return this.values.stream()
                          .filter(numberSet::contains)
                          .count();
    }

    public boolean contains(Number number) {
        return this.values.contains(number);
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
