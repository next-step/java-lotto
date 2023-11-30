package lotto.model;

import java.util.List;

public class WinningNumbers extends LottoNumbers {

    private final int bonusNumber;

    public WinningNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        super(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonusNumber(int lottoNumber) {
        return this.bonusNumber == lottoNumber;
    }

}
