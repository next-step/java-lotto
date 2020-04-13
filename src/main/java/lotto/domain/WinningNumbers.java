package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private Lotto winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> asList, int bonusNumber) {
        this.winningNumbers = new Lotto(asList);
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(List<Integer> asList, int bonusNumber) {
        return new WinningNumbers(asList, bonusNumber);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
