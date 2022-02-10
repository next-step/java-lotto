package lotto.domain;

import java.util.List;

public class WinningLottery {

    private static final String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private List<LottoNumber> winningNumber;
    private LottoNumber bonusNumber;

    public WinningLottery(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
