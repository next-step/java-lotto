package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<Rank, Integer> lottoPrizeResult;
    private BigDecimal purchaseAmount;

    private LottoStatistics(final int amount) {
        this.lottoPrizeResult = new HashMap<>();
        this.purchaseAmount = new BigDecimal(String.valueOf(amount));
    }

    public static LottoStatistics from(final int amount) {
        return new LottoStatistics(amount);
    }

    public void makeStatisticsResult(final Lottos lottos, final WinningLotto winningLotto) {
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.MISS))
                .forEach(rank -> lottoPrizeResult.put(rank, lottos.getRankCount(winningLotto, rank)));
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Rank key : lottoPrizeResult.keySet()) {
            totalPrizeMoney += key.getAmount() * lottoPrizeResult.get(key);
        }
        return totalPrizeMoney;
    }

    public BigDecimal getRevenueRate() {
        BigDecimal totalPrizeAmount = new BigDecimal(String.valueOf(getTotalPrizeMoney()));
        return totalPrizeAmount.divide(this.purchaseAmount, 2, RoundingMode.HALF_EVEN);
    }

    public Map<Rank, Integer> getLottoPrizeResult() {
        return Collections.unmodifiableMap(lottoPrizeResult);
    }
}
