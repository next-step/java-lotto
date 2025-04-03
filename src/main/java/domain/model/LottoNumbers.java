package domain.model;

import java.util.List;

import static constant.LottoConstants.*;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    int countMatch(LottoNumbers winNumbers) {
        return (int) winNumbers.getNumbers().stream()
                .filter(this.numbers::contains)
                .count();
    }

    private void validate() {
        validateSize();
        validateRange();
        validateNoDuplicates();
    }

    private void validateSize() {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto numbers must contain exactly 6 numbers.");
        }
    }

    private void validateRange() {
        boolean hasInvalid = numbers.stream()
                .anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER);
        if (hasInvalid) {
            throw new IllegalArgumentException("Lotto numbers must be between 1 and 45.");
        }
    }

    private void validateNoDuplicates() {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("Lotto numbers must not contain duplicates.");
        }
    }
}
