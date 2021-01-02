package lotto.oop.domain;

import java.util.List;

public class WinNumber {
    private List<LottoNumber> winNumbers;
    private int bonusNumber;

    public WinNumber(List<LottoNumber> winNumbers, int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers.get(0).getGenerateNumbers();
    }
}
