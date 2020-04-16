package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningNumbers = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(List<Integer> numbers, int bonusNumber) {
        return new WinningNumbers(numbers, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
