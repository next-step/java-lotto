package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final static String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";

    private List<LottoNumber> winningNumber;
    private LottoNumber bonusNumber;

    public WinningNumbers(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getWinningNumber() {
        return winningNumber;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
