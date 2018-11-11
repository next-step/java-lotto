package net.chandol.lotto.domain;

import net.chandol.lotto.util.LottoNumberValidator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private LottoNumber lottoNumber;
    private Integer bonusNumber;

    public WinningNumber(LottoNumber lottoNumber, Integer bonusNumber) {
        validateNumbers(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateNumbers(LottoNumber lottoNumber, Integer bonusNumber) {
        validateNotNull(lottoNumber, bonusNumber);
        validateBonusNumberRange(bonusNumber);
        validateUniqueNumbers(lottoNumber, bonusNumber);
    }

    private void validateNotNull(LottoNumber lottoNumber, Integer bonusNumber) {
        if (lottoNumber == null || bonusNumber == null) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (LottoNumberValidator.isInvalidLottoRange(bonusNumber)) {
            throw new IllegalArgumentException("bonus 번호를 확인해주세요.");
        }
    }

    private void validateUniqueNumbers(LottoNumber lottoNumber, Integer bonusNumber) {
        List<Integer> numbers = new ArrayList<>(lottoNumber.getLottoNumbers());
        numbers.add(bonusNumber);

        LottoNumberValidator.validateUniqueNumbers(numbers);
    }
}
