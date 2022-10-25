package lotto.domain;

import lotto.exception.InvalidInputException;

public class LottoNumber {
    private static final String VALIDATE_BONUS_NUMBER = "보너스 볼은 지난 주 당첨 번호와 중복될 수 없습니다.";

    private final Integer number;

    public LottoNumber(LottoNumbers lottoNumbers, Integer bonusNumber) {
        this.number = validateBonusNumber(lottoNumbers, bonusNumber);
    }

    public LottoNumber(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private Integer validateBonusNumber(LottoNumbers lottoNumbers, Integer bonusNumber) {
        if (lottoNumbers.getLottoNumbers().contains(bonusNumber)) {
            throw new InvalidInputException(VALIDATE_BONUS_NUMBER);
        }
        return bonusNumber;
    }
}
