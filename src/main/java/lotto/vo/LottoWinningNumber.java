package lotto.vo;

import lotto.domain.Lotto;

import java.util.List;

public class LottoWinningNumber {
    private List<LottoNo> winningNumber;

    private LottoNo bonusNumber;

    public LottoWinningNumber(List<LottoNo> winningNumber, LottoNo bonusNumber) throws IllegalArgumentException {
        //중복 입력 체크
        if (winningNumber.size() != Lotto.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("중복 당첨숫자 있음");
        }

        //보너스번호 중복 체크
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 중복됨");
        }

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
