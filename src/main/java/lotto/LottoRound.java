package lotto;

import java.util.Set;

public class LottoRound {
    private final LottoNumber winnerNumbers;

    public LottoRound(Set<Integer> winnerNumbers) {
        this.winnerNumbers = new LottoNumber(winnerNumbers);
    }

    public LottoRound(LottoNumber winnerNumbers) {
        this.winnerNumbers = winnerNumbers;
    }

    public LottoRank checkLottoRank(LottoNumber lottoNumber) {
        return LottoRank.valueOfMatchCount(winnerNumbers.intersectCount(lottoNumber));
    }
}
