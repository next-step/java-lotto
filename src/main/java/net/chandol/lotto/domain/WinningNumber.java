package net.chandol.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static net.chandol.lotto.util.LottoNumberValidator.validateNumberRange;
import static net.chandol.lotto.util.LottoNumberValidator.validateUniqueNumbers;

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
        validateNumberRange(bonusNumber);
        validateUniqueNumbers(getMergedList(lottoNumber, bonusNumber));
    }

    public LottoPrize findPrize(LottoNumber inputLottoNumber) {
        Integer matchSize = inputLottoNumber.getMatchSize(this.lottoNumber);
        boolean isMatchBonusNumber = inputLottoNumber.containsNumber(bonusNumber);

        return LottoPrize.getMatchingPrize(matchSize, isMatchBonusNumber);
    }

    private List<Integer> getMergedList(LottoNumber lottoNumber, Integer bonusNumber) {
        List<Integer> numbers = new ArrayList<>(lottoNumber.getLottoNumbers());
        numbers.add(bonusNumber);

        return numbers;
    }

    private void validateNotNull(LottoNumber lottoNumber, Integer bonusNumber) {
        if (lottoNumber == null || bonusNumber == null) {
            throw new IllegalArgumentException("입력값을 확인해주세요.");
        }
    }
}
