package step2.domain;

import java.util.List;

public class Number {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Number(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> winningNumbers() {
        return winningNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
