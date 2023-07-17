package lotto.domain.lotto;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

import java.text.MessageFormat;
import java.util.List;

public final class WinningNumber {

    private final Lotto winningLotto;
    private final LottoNumber bonusBall;

    public WinningNumber(final List<Integer> lottoValue, final int bonusValue) {
        Lotto lotto = new Lotto(lottoValue);
        LottoNumber lottoNumber = new LottoNumber(bonusValue);

        validate(lotto, lottoNumber);

        winningLotto = lotto;
        bonusBall = lottoNumber;
    }

    private void validate(final Lotto lotto, final LottoNumber lottoNumber) {
        if (lotto.hasLottoNumber(lottoNumber)) {
            throw new IllegalArgumentException(
                    MessageFormat.format("보너스볼이 당첨번호에 존재합니다. 보너스볼 번호 : {0}", lottoNumber.getLottoNumber())
            );
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusBall(){
        return bonusBall;
    }
}
