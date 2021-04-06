package step4.domain.winning;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;

public final class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber lottoNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber lottoNumber) {
        this.winningLotto = winningLotto;
        this.lottoNumber = lottoNumber;
    }

    public static final WinningLotto from(String winningLotto, int bonusLottoNumber) {
        return from(Lotto.of(winningLotto), LottoNumber.valueOf(bonusLottoNumber));
    }

    public static final WinningLotto from(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(winningLotto, bonusLottoNumber);
    }


}
