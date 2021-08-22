package step4.lotto;

import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.InvalidLottoNumberException;

public class TotalLottoNumber {

    private final LottoNumber lottoNumber;
    private final LottoNo bonusNumber;

    public TotalLottoNumber(LottoNumber lottoNumber, LottoNo bonusNumber) {
        validateBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumber lottoNumber, LottoNo bonusNumber) {
        boolean duplicatedNumber = lottoNumber.contains(bonusNumber);

        if (duplicatedNumber)
            throw new InvalidLottoNumberException(ExceptionMessage.NUMBER_DUPLICATED_BONUS_NUMBER);
    }

    public long countOfMatch(LottoNumber lottoNumber) {
        return lottoNumber.stream()
                .filter(this.lottoNumber::contains)
                .count();
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}
