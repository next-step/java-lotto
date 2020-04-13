package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> asList, int bonusNumber) {
        this.winningNumbers = asList;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(List<Integer> asList, int bonusNumber) {
        return new WinningNumbers(asList, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
