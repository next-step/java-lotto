package lotto.domain;

import java.util.List;

public class LottoMachine {

    private final List<LottoNumber> winNumbers;
    private final int bonusNumber;

    public LottoMachine(final List<LottoNumber> winNumbers, final int bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }

    // TODO 리뷰어 님께 물어보기
    public boolean isEqualBonusNumber(final LottoNumber lottoNumber) {
        return bonusNumber == lottoNumber.getLottoNumber();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return winNumbers.contains(lottoNumber.getLottoNumber());
    }
}
