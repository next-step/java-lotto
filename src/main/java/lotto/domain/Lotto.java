package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        validation(numbers);
        this.numbers = numbers;
        sort();
    }

    public void validation(final List<Number> numbers) {
        if (numbers.size() <= 0 || numbers.size() > 6)
            throw new IllegalArgumentException("로또 번호는 6개의 숫자여야 합니다.");
    }

    public void sort() {
        Collections.sort(numbers);
    }

    public List<Number> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Number::value)
                .collect(Collectors.toList())
                .toString();
    }
}
