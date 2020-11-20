package lotto.domain;

import lotto.domain.enums.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class LottoReport {
    private static final String BREAK_EVEN = "본전";
    private static final String GAIN = "이득";
    private static final String LOSS = "손해";
    private Long cost = 0L;
    private Long totalEarnings = 0L;
    private final Map<Rank, Integer> rankMap = new HashMap<>();

    public Long getTotalEarnings() {
        return totalEarnings;
    }

    public void addEarnings(Long earning) {
        totalEarnings += earning;
    }

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }

    public void addRanks(Rank rank) {
        rankMap.compute(rank, (key, count) -> count == null ? 1 : ++count);
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getCost() {
        return cost;
    }

    public BigDecimal getEarningRate() {
        return BigDecimal.valueOf(totalEarnings).divide(BigDecimal.valueOf(cost), 2, RoundingMode.HALF_UP);
    }

    public void addPrize(Prize prize) {
        addRanks(prize.getRank());
        addEarnings(prize.getCash());
    }

    public String getEarningRateDescription() {
        if(totalEarnings.equals(cost)){
            return BREAK_EVEN;
        }
        return totalEarnings.compareTo(cost) > 0  ? GAIN : LOSS;
    }
}
