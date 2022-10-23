package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;

public class LottoWinner extends Lotto {

    private final LottoNumber bonusNumber;
    private static final String LOTTOWINNER_BONUSNUMBER_EXCEPTION = "보너스 번호는 다른 번호와 겹칠 수 없습니다.";

    public LottoWinner(final LottoNumberSet lottoNumberSet, final LottoNumber bonusNumber) {
        super(lottoNumberSet);
        if (lottoNumberSet.contain(bonusNumber)) {
            throw new IllegalArgumentException(LOTTOWINNER_BONUSNUMBER_EXCEPTION);
        }
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(final Lotto lotto) {
        return Rank.rankValue(this.lottoNumbers.match(lotto.lottoNumbers), lotto.lottoNumbers.contain(bonusNumber));
    }
}
