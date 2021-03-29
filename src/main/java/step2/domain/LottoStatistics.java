package step2.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<Prize, Integer> lottoPrizeResult;
    private BigDecimal purchaseAmount;

    private LottoStatistics(final int amount) {
        this.lottoPrizeResult = new HashMap<>();
        this.purchaseAmount = new BigDecimal(String.valueOf(amount));
    }

    public static LottoStatistics from(final int amount) {
        return new LottoStatistics(amount);
    }

    public void makeStatisticsResult(final Lottos lottos, final Lotto prizeLotto) {
        Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.FAIL))
                .forEach(prize -> lottoPrizeResult.put(prize, lottos.getPrizeCount(prizeLotto, prize)));
    }

    private int getTotalPrizeAmount(final Lottos lottos, final Lotto prizeLotto) {
        return lottos.getLottos()
                .stream()
                .map(lotto -> lotto.getMatchCount(prizeLotto))
                .map(matchCount -> Prize.findPrize(matchCount))
                .map(Prize::getAmount)
                .reduce(0, Integer::sum);
    }

    public BigDecimal getRevenueRate(final Lottos lottos, final Lotto prizeLotto) {
        BigDecimal totalPrizeAmount = new BigDecimal(String.valueOf(getTotalPrizeAmount(lottos, prizeLotto)));
        return totalPrizeAmount.divide(this.purchaseAmount, 2, RoundingMode.HALF_EVEN);
    }

    public Map<Prize, Integer> getLottoPrizeResult() {
        return Collections.unmodifiableMap(lottoPrizeResult);
    }
}
