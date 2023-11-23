package domain.lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
    private int totalProfit;

    public LottoStatistics() {
        rankCounts.putAll(Map.of(
                Rank.FIRST, 0,
                Rank.SECOND, 0,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 0,
                Rank.MISS, 0));
    }


    public void calculate(int matchCount, boolean matchBonusBall) {
        if (isSecondWin(matchCount, matchBonusBall)) {
            updateSecondWin();
            return;
        }
        updateRankCounts(Rank.valueOf(matchCount));
    }

    private boolean isSecondWin(int matchCount, boolean matchBonusBall) {
        return matchCount == Rank.SECOND.getCountOfMatch() && matchBonusBall;
    }

    private void updateSecondWin() {
        Rank rank = Rank.SECOND;
        updateRankCounts(rank);
    }

    private void updateRankCounts(Rank rank) {
        rankCounts.put(rank, rankCounts.get(rank) + 1);
        totalProfit += rank.getWinningMoney();
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }
}
