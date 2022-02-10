package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class Numbers {

    private static final String DUPLICATES_NOT_AVAILABLE = "중복이 존재할 수 없습니다.";

    private final List<Number> numbers;

    public Numbers(final List<Number> numbers) {
        validateDuplicatedNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Number> get() {
        return Collections.unmodifiableList(numbers);
    }

    public int countMatches(final List<Number> comparison) {
        return (int) numbers.stream()
            .filter(comparison::contains)
            .count();
    }

    public boolean hasBonus(final Number bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int size() {
        return numbers.size();
    }

    private void validateDuplicatedNumbers(List<Number> numbers) {
        int distinctSize = Math.toIntExact(numbers.stream()
            .mapToInt(Number::value)
            .distinct()
            .count());

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException(DUPLICATES_NOT_AVAILABLE);
        }
    }

}
