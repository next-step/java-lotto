package lotto.vo;

import lotto.domain.Lotto;

public class LottoWinningNumber {
    private Lotto winningNumber;

    private LottoNo bonusNumber;

    public LottoWinningNumber(Lotto winningNumber, LottoNo bonusNumber) throws IllegalArgumentException {
        //보너스번호 중복 체크
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복됨");
        }

        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public LottoNo getBonusNumber() {
        return bonusNumber;
    }
}
