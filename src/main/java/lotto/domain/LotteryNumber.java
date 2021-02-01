package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LotteryNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LotteryNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;

        sortWinningNumber();
    }

    private void sortWinningNumber() {
        Collections.sort(winningNumbers);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}