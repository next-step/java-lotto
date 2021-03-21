package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public final static int MIN_NUMBER_LENGTH = 0;
    public final static int MAX_NUMBER_LENGTH = 6;
    private final List<Number> numbers;

    public Lotto(final List<Number> numbers) {
        validation(numbers);
        this.numbers = numbers;
        sort();
    }

    public void validation(final List<Number> numbers) {
        if (numbers.size() <= MIN_NUMBER_LENGTH || numbers.size() > MAX_NUMBER_LENGTH)
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
