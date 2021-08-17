package step3.lotto;

import step3.lotto.exception.InvalidLottoNumberException;

public class TotalLottoNumber {

    private final LottoNumber lottoNumber;
    private final BonusNumber bonusNumber;

    public TotalLottoNumber(LottoNumber lottoNumber, BonusNumber bonusNumber) {
        validateBonusNumber(lottoNumber, bonusNumber);
        this.lottoNumber = lottoNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(LottoNumber lottoNumber, BonusNumber bonusNumber) {
        boolean duplicatedNumber = lottoNumber.contains(bonusNumber.getNumber());

        if (duplicatedNumber)
            throw new InvalidLottoNumberException("보너스 넘버와 로또번호는 중복될 수 없습니다");
    }

    public long countOfMatch(LottoNumber lottoNumber) {
        return lottoNumber.stream()
                .filter(this.lottoNumber::contains)
                .count();
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber.getNumber());
    }
}
