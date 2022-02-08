package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final static String ERROR_DISTINCT = "당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private List<LottoNumber> winningNumber;
    private LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        validate();
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate() {
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_DISTINCT);
        }
    }
}
