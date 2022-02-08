package lotto.domain;

import java.util.List;

public class WinningNumber {

    private List<LottoNumber> winningNumber;
    private LottoNumber bonusNumber;

    public WinningNumber(List<LottoNumber> winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
}
