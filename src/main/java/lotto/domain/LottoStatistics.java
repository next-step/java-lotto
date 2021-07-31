package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final int DEFAULT_SUMMARY_VALUE = 0;
    private static final int SUMMARY_INCREASE_VALUE = 1;
    private static final int DIVIDE_SCALE = 2;
    private final Map<LottoMatchType, Integer> statisticsMap;
    private double profitMoney;


    public LottoStatistics() {
        this.statisticsMap = new EnumMap<>(LottoMatchType.class);
        this.profitMoney = 0;
    }

    public Map<LottoMatchType, Integer> getStatisticsMap() {
        return statisticsMap;
    }

    public void summary(Lottos buyLotto, WinningLotto winningLotto) {
        buyLotto.mapToResult(winningLotto)
                .forEach(k -> {
                    LottoMatchType matchType = LottoMatchType.findMatchCount(k.getCount(), k.isMatchBonus());
                    profitMoney += matchType.getWinMoney();
                    statisticsMap.put(matchType, statisticsMap.getOrDefault(matchType, DEFAULT_SUMMARY_VALUE) + SUMMARY_INCREASE_VALUE);
                });
    }

    public double profitRate(Lottos buyLotto) {
        int purchaseMoney = Money.purchaseMoney(buyLotto.getLottos().size());
        BigDecimal total = BigDecimal.valueOf(purchaseMoney);
        BigDecimal profit = BigDecimal.valueOf(profitMoney);
        return profit.divide(total, DIVIDE_SCALE, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
