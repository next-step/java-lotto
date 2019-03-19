package lotto.vo;

import java.util.List;

public class LottoWinningNumber {
    private List<LottoNo> winningNumber;

    private LottoNo bonusNumber;

    public LottoWinningNumber(List<LottoNo> winningNumber, LottoNo bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNo> getWinningNumber() {
        return winningNumber;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }
}
