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

        if (lottoWinInfo.equals(LottoWinInfo.WIN_SECOND) && this.lottoNumbers.containNumbers(bonusNumber)) {
            return LottoWinInfo.WIN_FIRST_WITH_BONUS;
        }
        return lottoWinInfo;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
