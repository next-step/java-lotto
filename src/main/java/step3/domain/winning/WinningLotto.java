package step3.domain.winning;

import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.exception.LottoNumberNullPointerException;

import java.util.Objects;

public final class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLotto;


    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validateBonusLottoNumberNull(bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLottoNumber;
    }

    private final void validateBonusLottoNumberNull(LottoNumber bonusLottoNumber) {
        if(Objects.isNull(bonusLottoNumber)) {
            throw new LottoNumberNullPointerException();
        }
    }

    public static final WinningLotto from(Lotto lotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(lotto, bonusLottoNumber);
    }
}
