package lotto.domain;

import java.util.*;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        List<Number> nos = new ArrayList<>();
        for (int number : numbers) {
            nos.add(new Number(number));
        }
        validate(nos);
        this.numbers = nos;
    }

    private void validate(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);

        if (numberSet.size() > 0 && numberSet.size() < 6) {
            throw new IllegalArgumentException("중복을 제외한 6개의 숫자를 입력하세요.");
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int sumContainsCount(Numbers numbers) {
        return (int) this.numbers.stream()
                .filter(number -> numbers.contains(number))
                .count();
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

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
