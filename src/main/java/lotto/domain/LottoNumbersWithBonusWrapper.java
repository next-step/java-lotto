package lotto.domain;

import lotto.data.LottoNumberVO;
import lotto.data.LottoWinInfo;

public class LottoNumbersWithBonusWrapper {

    private final LottoNumbers lottoNumbers;
    private final LottoNumberVO bonusNumber;

    public LottoNumbersWithBonusWrapper(LottoNumbers lottoNumbers, LottoNumberVO bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoWinInfo countMatchWithWinningLottoNumbersWithBonusNumber(LottoNumbers winningLottoNumbers) {
        LottoWinInfo lottoWinInfo = lottoNumbers.countMatchWithWinningLottoNumbers(winningLottoNumbers);

        return LottoWinInfo.valueOf(lottoWinInfo.getMatchedCount(), this.lottoNumbers.containNumbers(bonusNumber));
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
