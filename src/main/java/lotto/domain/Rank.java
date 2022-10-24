package lotto.domain;

import java.math.BigDecimal;

public class Rank {
    private final RankMap rankMap;

    public Rank() {
        this.rankMap = new RankMap();
    }

    public Integer findRank(Prize prize) {
        return rankMap.getCount(prize).getCount();
    }

    public void settingRank(int matchingCount, boolean containBonusNumber) {
        addRankMap(Prize.findPrize(matchingCount, containBonusNumber));
    }

    private void addRankMap(Prize prize) {
        RankCount rankCount = rankMap.getCount(prize);
        rankMap.putCount(prize, rankCount.rankCountPlusOne());
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
