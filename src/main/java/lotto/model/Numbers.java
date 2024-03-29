package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers valueOf(List<Integer> numbers) {
        List<Number> numberList = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());

        return new Numbers(numberList);
    }

    public boolean contains(Number value) {
        return numbers.stream()
                .anyMatch(number -> number.equals(value));
    }

    public int size() {
        return numbers.size();
    }

    public long[] toArray() {
        return IntStream.range(0, size())
                .mapToLong(i -> numbers.get(i).getValue())
                .toArray();
    }

    public List<Number> getNumberList() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public void shuffle() {
        Collections.shuffle(this.numbers);
    }
}
