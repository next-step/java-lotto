package lotto.entity;

import java.util.Set;

public class WinningNumbers {
    private final Set<Integer> numbers;

    public WinningNumbers(Set<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(Set<Integer> numbers) {
        LottoNumberSize.validateSize(numbers);
        validateRange(numbers);
    }

    private void validateRange(Set<Integer> numbers) {
        for (Integer number : numbers) {
            LottoNumberRange.validateRange(number);
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
