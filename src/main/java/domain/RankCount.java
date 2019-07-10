package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class RankCount {
    private Map<Rank, Integer> rankCount = new HashMap<>();

    public RankCount(LottoPaper lottoPaper, WinningLotto winningLotto) {
        Arrays.stream(Rank.values())
                .forEach(rank -> rankCount.put(rank, 0));

        lottoPaper.getLottoSets().stream()
                .forEach(lottoSet -> {
                    Rank rank = Rank.valueOf(winningLotto.getMatchNumber(lottoSet), winningLotto.isMatchBonusNumber(lottoSet));
                    plusCount(rank);
                });
    }

    private void plusCount(Rank rank) {
        int previousCount = rankCount.get(rank);
        rankCount.put(rank, previousCount + 1);
    }

    public int getNumberOfRankCount(Rank rank) {
        return rankCount.get(rank);
    }

    public double calculateProfit() {
        int totalPrice = rankCount.values().stream().mapToInt(Integer::intValue).sum() * LottoMoney.TICKET_PRICE;
        return Math.floor(calculateTotalWinningMoney() / totalPrice * 100) / 100.0;
    }

    private double calculateTotalWinningMoney() {
        double sum = 0;
        for (Rank rank : rankCount.keySet()) {
            sum += rank.getWinningMoney() * rankCount.get(rank);
        }

        return sum;
    }

    public Map<Rank, Integer> getRankCount() {
        return rankCount;
    }
}