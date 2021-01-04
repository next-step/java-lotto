package lotto.oop.domain;

import java.util.List;

public class WinNumber {
    private LottoNumber winNumbers;
    private LottoNo bonusNumber;

    public WinNumber(LottoNumber winNumbers, LottoNo bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.getNum();
    }

    public List<Integer> getWinNumbers() {
        return winNumbers.getGenerateNumbers();
    }
}
