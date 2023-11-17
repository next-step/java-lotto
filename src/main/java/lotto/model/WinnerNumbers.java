package lotto.model;

import java.util.Set;

public class WinnerNumbers {
    private final Set<Integer> numbers;

    public WinnerNumbers(LottoNumbers numbers) {
        this.numbers = numbers.lottoNumbers();
    }

    public WinnerNumbers(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean has(int number) {
        return this.numbers.contains(number);
    }
}
