package lotto.automatic.domain;

import java.math.BigDecimal;
import java.util.List;

public class LottoResult {

    private final int investMoney;
    private final List<LottoRank> rankList;

    public LottoResult(int investMoney, List<LottoRank> rankList) {
        this.investMoney = investMoney;
        this.rankList = rankList;
    }

    public long getRankCount(LottoRank rank) {

        return rankList.stream()
                .filter(r -> r.matchCount == rank.matchCount)
                .count();
    }

    public BigDecimal calculateEarningRate() {

        BigDecimal earningMoney = BigDecimal.ZERO;

        for (LottoRank rank : rankList) {
            earningMoney = earningMoney.add(BigDecimal.valueOf(rank.earningMoney));
        }

        System.out.println(earningMoney.intValue());

        return earningMoney.divide(BigDecimal.valueOf(investMoney), 2, BigDecimal.ROUND_CEILING);
    }
}
