package lotto;

import java.util.List;

public class WinNumber {

    private final List<LottoNumber> winNumbers;
    private final int bonusNumber;

    public WinNumber(List<Integer> winNumbers, int bonusNumber) {
        this.winNumbers = LottoNumber.of(winNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public List<LottoNumber> getWinNumbers() {
        return this.winNumbers;
    }
}
