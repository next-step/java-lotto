package lotto.domain;

import java.util.*;

import static lotto.domain.LottoGame.NUMBER_BOUND;

public class Numbers {
    private final List<Number> numbers;

    public Numbers(List<Integer> numbers) {
        List<Number> nos = new ArrayList<>();
        for (int number : numbers) {
            nos.add(Number.of(number));
        }
        validate(nos);
        this.numbers = nos;
    }

    private void validate(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);

        if (numberSet.size() > 0 && numberSet.size() != NUMBER_BOUND) {
            throw new IllegalArgumentException(String.format(
                    "중복을 제외한 %d개의 숫자를 입력하세요.",
                    NUMBER_BOUND));
        }
    }

    public boolean contains(Number number) {
        return numbers.contains(number);
    }

    public int sumContainsCount(Numbers numbers) {
        return (int) this.numbers.stream()
                .filter(numbers::contains)
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
