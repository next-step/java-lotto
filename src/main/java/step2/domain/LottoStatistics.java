package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class LottoStatistics {

    private double earningRate;

    public LottoStatistics(int paymentMoney, List<Integer> matchResult) {
        this.earningRate = calculateProfitRate(paymentMoney, matchResult);
    }

    public Map<Integer, List<Rank>> statistics(List<Integer> matchResult) {
        return groupMatchOfLotto(matchResult);
    }

    public Map<Integer, List<Rank>> groupMatchOfLotto(List<Integer> matchResult) {
        Map<Integer, List<Rank>> statisticsOfRank = matchResult.stream()
                .map(Rank::valueOf)
                .collect(groupingBy(Rank::getCountOfMatch));

        Rank[] values = Rank.values();
        for (int i = 0; i < Rank.values().length; i++) {
            inputEmptyList(statisticsOfRank, values[i].getCountOfMatch());
        }
        return statisticsOfRank;
    }

    private void inputEmptyList(Map<Integer, List<Rank>> collect, int countOfMatch) {
        if (!collect.containsKey(countOfMatch)) {
            collect.put(countOfMatch, new ArrayList<>());
        }
    }

    private double calculateProfitRate(int money, List<Integer> matchResult) {
        money = 0;
        Integer totalProfit = matchResult.stream()
                .map(Rank::valueOf)
                .map(Rank::getWinningMoney)
                .reduce(Integer::sum)
                .orElse(0);
        return totalProfit / (double) money;
    }

    public String getStringEarningRate() {
        System.out.println(earningRate);
        return String.format("%.2f", earningRate);
    }
}
