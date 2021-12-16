package lotto.domain;

import java.util.List;

public class PrizeLotto {
    private static final String EXCEPTION_MESSAGE_SAME_NUMBER = "동일한 로또 번호가 존재합니다.";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public PrizeLotto(String winLottoNumbers, String bonusNumber) {
        this(new Lotto(winLottoNumbers), LottoNumber.from(bonusNumber));
    }

    public PrizeLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contain(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_SAME_NUMBER);
        }
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
