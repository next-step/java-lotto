package lotto.domain;

import java.util.TreeSet;

public class WinnerLotto {

    private final TreeSet<Integer> winningNumbers;

    private final int bonusNumber;

    public WinnerLotto(final TreeSet<Integer> numbers, final int bonusNumber) {
        this.winningNumbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean hasMatchNumber(int number) {
        return winningNumbers.contains(number);
    }

}
