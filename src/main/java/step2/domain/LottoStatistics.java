package step2.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class LottoStatistics {

    private final double earningRate;

    public LottoStatistics(int paymentMoney, List<Integer> matchResult) {
        this.earningRate = calculateProfitRate(paymentMoney, matchResult);
    }

    public Map<Integer, List<Rank>> statistics(List<Integer> matchResult, List<Boolean> matchOfBonus) {
        return groupMatchOfLotto(matchResult, matchOfBonus.iterator());
    }

    public Map<Integer, List<Rank>> groupMatchOfLotto(List<Integer> matchResult, List<Boolean> matchOfBonus) {
        Map<Integer, List<Rank>> statisticsOfRank = matchResult.stream()
                .map(Rank::valueOf)
                .collect(groupingBy(Rank::getCountOfMatch));

        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(statisticsOfRank, values[i].getCountOfMatch());
        }
        return statisticsOfRank;
    }

    public Map<Integer, List<Rank>> groupMatchOfLotto(List<Integer> matchResult, Iterator<Boolean> matchOfBonus) {
        Map<Integer, List<Rank>> statisticsOfRank = matchResult.stream()
                .map(countOfMatch -> Rank.valueOf(countOfMatch, matchOfBonus.next()))
                .collect(groupingBy(Rank::getWinningMoney));

        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(statisticsOfRank, values[i].getWinningMoney());
        }
        return statisticsOfRank;
    }

    private void inputEmptyList(Map<Integer, List<Rank>> collect, int winnigMoney) {
        if (!collect.containsKey(winnigMoney)) {
            collect.put(winnigMoney, new ArrayList<>());
        }
    }

    private double calculateProfitRate(int money, List<Integer> matchResult) {
        Integer totalProfit = matchResult.stream()
                .map(Rank::valueOf)
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum)
                .orElse(0);
        return totalProfit / (double) money;
    }

    public String getStringEarningRate() {
        return String.format("%.2f", earningRate);
    }
}
