package lotto.domain.lotto;

import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;

public class LottoWinner extends Lotto {

    private final LottoNumber bonusNumber;
    private final String LOTTOWINNER_BONUSNUMBER_EXCEPTION = "보너스 번호는 다른 번호와 겹칠 수 없습니다.";

    public LottoWinner(final LottoNumberSet lottoNumberSet, final LottoNumber bonusNumber) {
        super(lottoNumberSet);
        if (lottoNumberSet.contain(bonusNumber)) {
            throw new IllegalArgumentException(LOTTOWINNER_BONUSNUMBER_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public int rank(final Lotto lotto) {
        if (this.lottoNumbers.match(lotto.lottoNumbers) == 3) {
            return 5;
        }
        if (this.lottoNumbers.match(lotto.lottoNumbers) == 4) {
            return 4;
        }
        if (this.lottoNumbers.match(lotto.lottoNumbers) == 5) {
            return matchBonusNumber(lotto);
        }
        if (this.lottoNumbers.match(lotto.lottoNumbers) == 6) {
            return 1;
        }
        return 0;
    }

    private int matchBonusNumber(final Lotto lotto) {
        if (lotto.lottoNumbers.contain(bonusNumber)) {
            return 2;
        }
        return 3;
    }
}
