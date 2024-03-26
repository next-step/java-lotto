package lotto.domain;

import lotto.domain.lotto.LottoNumber;

import java.util.List;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    private BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber valueOf(LottoNumber bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public boolean isMatched(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(bonusNumber::equals);
    }

    public int number() {
        return bonusNumber.number();
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
