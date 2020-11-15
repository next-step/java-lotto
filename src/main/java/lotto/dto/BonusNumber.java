package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.exception.IllegalBonusNumberException;

import java.util.Set;

public class BonusNumber {
    public static final String INVALID_BONUS_NUMBER_ERR_MSG = "보너스번호는 당첨번호와 같을 수 없습니다.";

    private final LottoNumber lottoNumber;

    private BonusNumber(LottoNumber lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static BonusNumber valueOf(int number) {
        LottoNumber lottoNumber = LottoNumber.valueOf(number);
        return new BonusNumber(lottoNumber);
    }

    public void validateBonusNumber(Lotto winningLotto) {
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalBonusNumberException(INVALID_BONUS_NUMBER_ERR_MSG);
        }
    }

    public boolean included(Set<LottoNumber> numbers) {
        return numbers.contains(lottoNumber);
    }
}
