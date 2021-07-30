package lotto.domain;

import lotto.exception.OverlapNumberException;

public class WinningLotto {
    private final Lotto value;
    private final LottoNumber bonusNumber;
    public WinningLotto(Lotto value, LottoNumber bonusNumber) {
        validateOverlapBonusNumber(value, bonusNumber);

        this.value = value;
        this.bonusNumber = bonusNumber;
    }

    private void validateOverlapBonusNumber(Lotto value, LottoNumber bonusNumber) {
        if (value.contains(bonusNumber)) {
            throw new OverlapNumberException("보너스 번호와 당첨 번호는 중복되는 번호가 없어야 합니다.");
        }
    }

    private boolean isSecondPlace(LottoRank lottoRank, Lotto lotto) {
        if (lottoRank != LottoRank.THREE_PLACE) {
            return false;
        }
        return lotto.contains(bonusNumber);
    }

    public LottoRank rank(Lotto lotto) {
        LottoRank lottoRank = LottoRank.of(
                this.value.containsCount(lotto)
        );
        return isSecondPlace(lottoRank, lotto) ? LottoRank.SECOND_PLACE : lottoRank;
    }
}
