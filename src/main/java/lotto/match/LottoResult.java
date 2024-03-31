package lotto.match;


import lotto.prize.PrizeRateStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoPrizeCount> lottoPrizeCounts;

    public LottoResult(List<LottoPrizeCount> lottoPrizeCounts) {
        this.lottoPrizeCounts = lottoPrizeCounts;
    }

    private int calculateTotalEarnings() {
        return lottoPrizeCounts.stream().mapToInt(LottoPrizeCount::getTotalMoney).sum();
    }

    public double getWinningPercent(PrizeRateStrategy rateStrategy, int lottoPrice) {
        int spendMoney = lottoPrice * lottoPrizeCounts.size();
        return rateStrategy.getRate(calculateTotalEarnings(), spendMoney);
    }

    public List<LottoPrizeCount> getStatistics() {
        return lottoPrizeCounts.stream()
                .filter(LottoPrizeCount::isLegal)
                .collect(Collectors.toList());
    }
}
