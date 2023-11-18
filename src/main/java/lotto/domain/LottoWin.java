package lotto.domain;

import java.util.List;

public class LottoWin {

    private final LottoWinNumbers lottoWinNumbers;
    private final BonusBall bonusBall;

    public LottoWin(LottoWinNumbers lottoWinNumbers, BonusBall bonusBall) {
        this.lottoWinNumbers = lottoWinNumbers;
        this.bonusBall = bonusBall;
    }

    public LottoRank matchCount(List<Integer> lottoNumbers) {
        return lottoWinNumbers.matchCount(lottoNumbers, bonusBall);
    }

}
