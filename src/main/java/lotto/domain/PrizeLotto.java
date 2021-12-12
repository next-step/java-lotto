package lotto.domain;

import java.util.List;

public class PrizeLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public PrizeLotto(String winLottoNumbers, String bonusNumber) {
        this(new Lotto(winLottoNumbers), LottoNumber.from(bonusNumber));
    }

    public PrizeLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonusNumber(Lotto targetLotto) {
        return targetLotto.contain(bonusNumber);
    }

    public boolean matchNumber(LottoNumber lottoNumber) {
        return lotto.contain(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto.getLottoNumbers();
    }
}
