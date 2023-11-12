package step2.domain;

import java.util.List;

import static step2.util.ListUtil.isContain;
import static step2.util.ListUtil.numberOfMatches;

public class PrizeLotto {

    private LottoNumbers lottoNumbers;
    private LottoNumber bonusNumber;

    public PrizeLotto(LottoNumbers lottoNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int countOfWinningNumber(Lotto lotto) {
        return numberOfMatches(lotto.numbers(), numbers());
    }

    public boolean isBonusMatched(Lotto lotto) {
        return isContain(lotto.numbers(), bonusNumber());
    }

    public List<Integer> numbers() {
        return this.lottoNumbers.numbers();
    }

    public int bonusNumber() {
        return this.bonusNumber.number();
    }

}
