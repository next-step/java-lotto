package lotto.domain;

import java.util.EnumMap;

public class WinningStatistics {

    private final EnumMap<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    public WinningStatistics(LotteryMachine machine, Lotto winningLotto) {
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
}
