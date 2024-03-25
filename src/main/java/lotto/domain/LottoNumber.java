package lotto.domain;

import java.util.List;

public class LottoNumber {
    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
        validateIfNotNull();
    }

    private void validateIfNotNull() {
        if (this.numbers == null) throw new IllegalArgumentException();
    }

    public int getMatchCount(WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getNumbers();
        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean isBonusContains(WinningNumber winningNumber) {
        Integer bonusNumber = winningNumber.getBonusNumber();
        return this.numbers.stream()
                .anyMatch(bonusNumber::equals);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
