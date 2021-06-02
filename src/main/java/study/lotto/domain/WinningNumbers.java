package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    Lotto winningLotto;
    LottoNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto lottoNumbers() {
        return winningLotto;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }


}
