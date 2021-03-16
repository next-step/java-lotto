package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private Map<LottoRank,Integer> lottoStaticResult;

    public LottoStatistics() {
        lottoStaticResult = new HashMap<>();
        init();
    }

    private void init() {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoStaticResult.put(lottoRank,0);
        }
    }

    public void put(LottoRank rank) {
        if(!LottoRank.isZero(rank)) {
            lottoStaticResult.put(rank,lottoStaticResult.get(rank)+1);
        }
    }

    private int sum() {
        int sum = 0;
        for (LottoRank rank : lottoStaticResult.keySet()) {
            sum += rank.getMatchingPrice() * lottoStaticResult.get(rank);
        }
        return sum;
    }

    public double calculate(int amount) {
        BigDecimal totalBigDecimal = new BigDecimal(sum());
        BigDecimal amountBigDecimal = new BigDecimal(amount);
        return totalBigDecimal
                .divide(amountBigDecimal,2,BigDecimal.ROUND_DOWN)
                .doubleValue();
    }



    public Map<LottoRank, Integer> getlottoStaticResultMap() {
        return lottoStaticResult;
    }

    public boolean isBenefit(double yield) {
        if(yield < 1) {
            return false;
        }
        return true;
    }
}
