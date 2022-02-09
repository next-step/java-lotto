package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        this.numbers = numbers;
    }

    public List<Number> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatches(final List<Number> comparison) {
        return (int) numbers.stream()
            .map(Number::value)
            .filter(comparison::contains)
            .count();
    }

    public boolean hasBonus(final Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int size() {
        return numbers.size();
    }
}
