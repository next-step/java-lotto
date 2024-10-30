package lotto.domain;

import java.util.List;

public class BonusBall {
    private final int bonusNumber;

    public BonusBall(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public boolean checkMatching(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.contains(new LottoNumber(bonusNumber));
    }

}
