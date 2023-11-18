package lotto.model;

import java.util.Set;

public class WinnerNumbers {
    private final Set<PositiveNumber> numbers;

    public WinnerNumbers(LottoNumbers numbers) {
        this.numbers = numbers.lottoNumbers();
    }

    public WinnerNumbers(Set<PositiveNumber> numbers) {
        this.numbers = numbers;
    }

    public boolean has(PositiveNumber number) {
        return numbers.stream()
                .anyMatch(positiveNumber -> positiveNumber.number() == number.number());
    }
}
