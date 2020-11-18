package step3.domain;

import step3.exception.BonusNumberDuplicateNumber;

public class LastWeekLotto {

    private final Lotto lastWeekLotto;
    private final LottoNumber bonusNumber;

    private LastWeekLotto(Lotto lastWeekLotto, LottoNumber bonusNumber) {

        validBonusNumber(lastWeekLotto , bonusNumber);

        this.lastWeekLotto = lastWeekLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validBonusNumber(Lotto lastWeekLotto , LottoNumber bonusNumber) {
        if(lastWeekLotto.has(bonusNumber)){
            throw new BonusNumberDuplicateNumber();
        }
    }

    public static LastWeekLotto of(Lotto lotto, LottoNumber bonusNumber) {
        return new LastWeekLotto(lotto, bonusNumber);
    }


    public LottoRank getRanking(Lotto lotto) {
        return LottoRank.valueOf(lastWeekLotto.matchLottoNumbers(lotto), lotto.has(bonusNumber));
    }


}
