package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Lotto winningNumbers;
    private LottoNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(List<Integer> winningValues, int bonusValue) {
        Lotto winningNumbers = Lotto.of(winningValues);
        LottoNumber bonusNumber = LottoNumber.from(bonusValue);
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}
