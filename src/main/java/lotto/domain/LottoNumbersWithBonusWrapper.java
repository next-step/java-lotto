package lotto.domain;

import lotto.data.LottoBall;
import lotto.data.LottoWinInfo;

public class LottoNumbersWithBonusWrapper {

    private final Lotto lottoNumbers;
    private final LottoBall bonusNumber;

    public LottoNumbersWithBonusWrapper(Lotto lottoNumbers, LottoBall bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoWinInfo countMatchWithWinningLottoNumbersWithBonusNumber(Lotto winningLottoNumbers) {
        LottoWinInfo lottoWinInfo = this.lottoNumbers.countMatchWithWinningLottoNumbers(winningLottoNumbers);

        return LottoWinInfo.valueOf(lottoWinInfo.getMatchedCount(), this.lottoNumbers.containNumbers(bonusNumber));
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
