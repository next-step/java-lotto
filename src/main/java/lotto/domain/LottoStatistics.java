package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {

    private static final int DEFAULT_SUMMARY_VALUE = 0;
    private static final int SUMMARY_INCREASE_VALUE = 1;
    private static final int DIVIDE_SCALE = 2;
    private final Map<LottoMatchType, Integer> statisticsMap;
    private final Lottos buyLotto;
    private final LottoNumbers winLotto;
    private double profitMoney;


    public LottoStatistics(LottoNumbers winLotto, Lottos buyLotto) {
        this.winLotto = winLotto;
        this.buyLotto = buyLotto;
        this.statisticsMap = new EnumMap<>(LottoMatchType.class);
        this.profitMoney = 0;
    }

    public static LottoStatistics of(LottoNumbers winTicket, Lottos buyTicket) {
        return new LottoStatistics(winTicket, buyTicket);
    }

    public Map<LottoMatchType, Integer> getStatisticsMap() {
        return statisticsMap;
    }

    public void summary() {
        buyLotto.mapToInt(winLotto)
                .forEach(k -> {
                    LottoMatchType matchType = LottoMatchType.findMatchCount(k);
                    profitMoney += matchType.getWinMoney();
                    statisticsMap.put(matchType, statisticsMap.getOrDefault(matchType, DEFAULT_SUMMARY_VALUE) + SUMMARY_INCREASE_VALUE);
                });
    }

    public double profitRate() {
        int purchaseMoney = Money.purchaseMoney(buyLotto.getLottos().size());
        BigDecimal total = BigDecimal.valueOf(purchaseMoney);
        BigDecimal profit = BigDecimal.valueOf(profitMoney);
        return profit.divide(total, DIVIDE_SCALE, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
