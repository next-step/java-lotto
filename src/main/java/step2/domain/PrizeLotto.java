package step2.domain;

import step2.domain.type.Prize;

public class PrizeLotto {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public PrizeLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Prize prize(Lotto lotto) {
        return Prize.of(countOfWinningNumber(lotto), isBonusMatched(lotto));
    }

    private int countOfWinningNumber(Lotto lotto) {
        return lotto.numberOfMatches(this.lottoNumbers);
    }

    private boolean isBonusMatched(Lotto lotto) {
        return lotto.isContain(this.bonusNumber);
    }

    public LottoNumbers lottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoNumber bonusNumber() {
        return this.bonusNumber;
    }

}
