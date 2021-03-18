package step2.domain;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class RankOfMatch {

    private final List<Integer> rankOfMatchList;

    public RankOfMatch(List<Integer> matchResult) {
        this.rankOfMatchList = matchResult;
    }

    public Map<Integer, Long> groupMatchOfLotto(Iterator<Boolean> matchOfBonus) {
        Map<Integer, Long> statisticsOfRank = rankOfMatchList.stream()
                .map(countOfMatch -> Rank.valueOf(countOfMatch, matchOfBonus.next()))
                .collect(groupingBy(Rank::getWinningMoney, counting()));

        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(statisticsOfRank, values[i].getWinningMoney());
        }
        return statisticsOfRank;
    }

    private void inputEmptyList(Map<Integer, Long> statisticsOfRank, int winningMoney) {
        if (!statisticsOfRank.containsKey(winningMoney)) {
            statisticsOfRank.put(winningMoney, 0L);
        }
    }

    public double calculateProfitRate(Money money) {
        int totalProfit = rankOfMatchList.stream()
                .map(Rank::valueOf)
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum)
                .orElseGet(() -> 0);
        return totalProfit / (double) money.toInt();
    }
}
