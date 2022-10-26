package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Rank {
    private final Map<Prize, RankCount> rankMap;

    public Rank() {
        this.rankMap = new HashMap<>();
        initRankMap(this.rankMap);
    }

    private void initRankMap(Map<Prize, RankCount> rankMap) {
        for (Prize value : Prize.values()) {
            rankMap.put(value, new RankCount(0));
        }
    }

    public Integer findRank(Prize prize) {
        return rankMap.get(prize).getCount();
    }

    public void settingRank(int matchingCount, boolean containBonusNumber) {
        addRankMap(Prize.findPrize(matchingCount, containBonusNumber));
    }

    private void addRankMap(Prize prize) {
        RankCount rankCount = rankMap.get(prize);
        rankMap.put(prize, rankCount.rankCountPlusOne());
    }

    public double calculateYield(BigDecimal purchaseAmount) {
        double earnedMoney = calculatePrizeMoney().subtract(purchaseAmount).doubleValue();
        return 1 + (earnedMoney / purchaseAmount.doubleValue());
    }

    private BigDecimal calculatePrizeMoney() {
        BigDecimal prizeMoney = BigDecimal.ZERO;

        for (Prize value : Prize.values()) {
            BigDecimal bigDecimal = BigDecimal.valueOf(findRank(value));
            prizeMoney = prizeMoney.add(bigDecimal.multiply(value.getPrizeMoney()));
        }

        return prizeMoney;
    }
}
