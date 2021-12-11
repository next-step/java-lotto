package lotto.domain;

import java.util.List;

public class PrizeLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public PrizeLotto(String winLottoNumbers, String bonusNumber) {
        this(new Lotto(winLottoNumbers), new LottoNumber(bonusNumber));
    }

    public PrizeLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.getLottoNumbers().contains(bonusNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto.getLottoNumbers();
    }
}
