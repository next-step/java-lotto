package lotto.model.winninglotto;

import lotto.model.lottonumber.LottoNumber;

public class BonusBall {
    private LottoNumber bonusNumber;

    public BonusBall(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusBall of(LottoNumber bonusNumber) {
        return new BonusBall(bonusNumber);
    }

    public boolean isEqualWith(LottoNumber bonusNumber) {
        return this.bonusNumber == bonusNumber;
    }
}