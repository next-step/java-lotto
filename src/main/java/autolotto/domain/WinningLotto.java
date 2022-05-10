package autolotto.domain;

import autolotto.exception.LottoException;
import autolotto.exception.LottoExceptionCode;

public class WinningLotto {
    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusBall) {
        this.lottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
        if (contains(bonusBall)) {
            throw new LottoException(LottoExceptionCode.DUPLICATED_LOTTO_NUMBER, bonusBall.toString());
        }
    }

    public boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
