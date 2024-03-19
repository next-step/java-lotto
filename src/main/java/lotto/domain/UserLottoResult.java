package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class UserLottoResult {
    private Map<LottoResult, Integer> countLottoResult = new EnumMap(LottoResult.class);
    private double rateOfReturn;

    public void addCount(LottoResult lottoResult) {
        countLottoResult.put(lottoResult, countLottoResult.getOrDefault(lottoResult, 0) + 1);
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public int getCountLottoResult(LottoResult lottoResult) {
        return countLottoResult.getOrDefault(lottoResult, 0);
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }
}
