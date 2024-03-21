package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class UserLottoResult {
    private Map<LottoWinningRank, Integer> countLottoResult = new EnumMap(LottoWinningRank.class);
    private double rateOfReturn;

    public void addCount(LottoWinningRank lottoWinningRank) {
        countLottoResult.put(lottoWinningRank, countLottoResult.getOrDefault(lottoWinningRank, 0) + 1);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public int getCountLottoResult(LottoWinningRank lottoWinningRank) {
        return countLottoResult.getOrDefault(lottoWinningRank, 0);
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
}
