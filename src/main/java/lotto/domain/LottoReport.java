package lotto.domain;

import lotto.domain.enums.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class LottoReport {
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
        return BigDecimal.valueOf(totalEarnings).divide(BigDecimal.valueOf(cost),  RoundingMode.HALF_UP);
    }

    public void addPrize(Prize prize) {
        addRanks(prize.getRank());
        addEarnings(prize.getCash());
    }
}
