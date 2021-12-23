package lotto.result;

import lotto.lotto.Lotto;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;

public class WinningNumbers {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    private WinningNumbers(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public Rank result(Lotto lotto) {
        long matchedLottoNumbersCount = lotto.match(winningNumbers);
        boolean matchedBonusNumber = lotto.isMatchedBonusNumber(bonusNumber);

        return Rank.valueOf(matchedLottoNumbersCount, matchedBonusNumber);
    }
}
