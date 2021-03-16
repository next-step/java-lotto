package step2.domain;

import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final RankOfMatch rankOfMatch;
    private final double earningRate;

    public LottoStatistics(List<Integer> matchResult, Money paymentMoney) {
        this.rankOfMatch = new RankOfMatch(matchResult);
        this.earningRate = calculateProfitRate(paymentMoney, matchResult);
    }

    public Map<Integer, List<Rank>> statistics(List<Boolean> matchOfBonus) {
        return rankOfMatch.groupMatchOfLotto(matchOfBonus.iterator());
    }

    private double calculateProfitRate(Money money, List<Integer> matchResult) {
        int totalProfit = matchResult.stream()
                .map(Rank::valueOf)
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum)
                .orElseGet(() -> 0);
        return Math.round(totalProfit / money.toDouble() * 100) / 100;
    }

    public double getEarningRate() {
        return earningRate;
    }
}
