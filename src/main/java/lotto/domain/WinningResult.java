package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class WinningResult {
    private Map<LottoRankEnum, Integer> mapOfResultl ;

    public WinningResult() {
        this.mapOfResultl = new HashMap<LottoRankEnum, Integer>();
    }

    public WinningResult(Map<LottoRankEnum, Integer> mapOfResultl) {
        this.mapOfResultl = mapOfResultl;
    }

    public void addResult(LottoRankEnum rank) {
        if(LottoRankEnum.LOSING_LOT.equals(rank)) {
            return ;
        }
        int count = 1;
        if (mapOfResultl.containsKey(rank)) {
            mapOfResultl.put(rank, mapOfResultl.get(rank) + count);
            return ;
        }
        mapOfResultl.put(rank, count);
    }

    public BigDecimal getRateOfReturn(int count) {
        if (mapOfResultl.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal totalReturn = mapOfResultl.entrySet().stream().map(x -> x.getKey().getWinningAmount().multiply(BigDecimal.valueOf(x.getValue()))).reduce(BigDecimal.ZERO, BigDecimal::add);

        return totalReturn.divide(LottoUnitAmount.getTotalPaymentAmount(count), 2,RoundingMode.DOWN);
    }

    public int getRankCount(LottoRankEnum rankEnum) {
        if (mapOfResultl.isEmpty()) {
            return 0;
        }
        return mapOfResultl.get(rankEnum) == null ? 0 : mapOfResultl.get(rankEnum);
    }
}
