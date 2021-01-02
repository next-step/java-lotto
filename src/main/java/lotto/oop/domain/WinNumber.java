package lotto.oop.domain;

import java.util.List;

public class WinNumber {
    private List<Integer> winNumbers;
    private int bonusNumber;

    public WinNumber(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
