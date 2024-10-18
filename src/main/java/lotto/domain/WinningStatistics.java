package lotto.domain;

import java.util.EnumMap;

public class WinningStatistics {

    private final EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
    private final LotteryMachine lotteryMachine;

    public WinningStatistics(LotteryMachine machine, Lotto winningLotto) {
        this.lotteryMachine = machine;
        calculateStatistics(machine, winningLotto);
    }

    private void calculateStatistics(LotteryMachine machine, Lotto winningLotto) {
        initialRankStatistics();
        for (Lotto lotto : machine.getLottos()) {
            Rank rank = Rank.valueOfMatchCount(lotto.countMatchingNumbers(winningLotto));
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
    }

    private void initialRankStatistics() {
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    public int getRankCount(Rank rank) {
        return rankCounts.get(rank);
    }

    public double calculateProfitRate() {
        int totalPrize = rankCounts.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        return (double) totalPrize / (double) lotteryMachine.getTotalPurchasePrice();
    }
}
