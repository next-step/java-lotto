package lottoAuto.model;

import java.math.BigDecimal;
import java.util.Map;

public class Revenue {
    private Map<Rank, Long> resultMap;
    private int price;

    public Revenue(Map<Rank, Long> resultMap, int price) {
        this.resultMap = resultMap;
        this.price = price;
    }

    public BigDecimal calculateRevenue() {
        BigDecimal sum = resultMap.entrySet().stream()
                .map(rankLongEntry -> Rank.calculatePrize(rankLongEntry.getKey(), rankLongEntry.getValue()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.divide(BigDecimal.valueOf(price));
    }

    public Map<Rank, Long> getResultMap() {
        return resultMap;
    }
}
