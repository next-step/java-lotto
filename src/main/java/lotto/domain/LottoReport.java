package lotto.domain;

import lotto.domain.enums.EarningRateType;
import lotto.domain.enums.Rank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class LottoReport {
    private final Long cost;
    private Long totalEarnings = 0L;
    private final Map<Rank, Integer> rankMap = new HashMap<>();

    public LottoReport(Long cost) {
        this.cost = cost;
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

    public BigDecimal getEarningRate() {
        return BigDecimal.valueOf(totalEarnings).divide(BigDecimal.valueOf(cost), 2, RoundingMode.HALF_UP);
    }

    public void addPrize(Prize prize) {
        addRanks(prize.getRank());
        addEarnings(prize.getCash());
    }

    public EarningRateType getEarningRateType() {
        if(totalEarnings.equals(cost)){
            return EarningRateType.BREAK_EVEN;
        }
        return totalEarnings.compareTo(cost) > 0  ? EarningRateType.GAIN : EarningRateType.LOSS;
    }
}
