package lotto.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Ranking;

public class LottoOutput {

    public void printRanking(List<Ranking> rankings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계");
        stringBuilder.append("-----------");

        Map<Ranking, Integer> rankingCount = countRanking(rankings);
        stringBuilder.append(Ranking.FIVE).append(" - ")
            .append(rankingCount.getOrDefault(Ranking.FIVE, 0)).append("개");
        stringBuilder.append(Ranking.FOUR).append(" - ")
            .append(rankingCount.getOrDefault(Ranking.FOUR, 0)).append("개");
        stringBuilder.append(Ranking.THREE).append(" - ")
            .append(rankingCount.getOrDefault(Ranking.THREE, 0)).append("개");
        stringBuilder.append(Ranking.TWO).append(" - ")
            .append(rankingCount.getOrDefault(Ranking.TWO, 0)).append("개");
        stringBuilder.append(Ranking.ONE).append(" - ")
            .append(rankingCount.getOrDefault(Ranking.ONE, 0)).append("개");

        System.out.println(stringBuilder);
    }

    private Map<Ranking, Integer> countRanking(List<Ranking> rankings) {
        Map<Ranking, Integer> successSum = new HashMap<>();
        for (Ranking ranking : rankings) {
            successSum.put(ranking, successSum.getOrDefault(successSum, 0) + 1);
        }
        return successSum;
    }

    public void printRewardRate(List<Ranking> rankings, int buyPrice) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ");
        int winnerPriceSum = countWinnerPriceSum(rankings);
        double rewardRate = countRewardRate(winnerPriceSum, buyPrice);
        stringBuilder.append(rewardRate);
    }

    private int countWinnerPriceSum(List<Ranking> rankings){
        return rankings.stream()
            .map(Ranking::getWinnerPrice)
            .reduce(0, Integer::sum);
    }

    private double countRewardRate(int winnerPriceSum, int buyPrice) {
        return winnerPriceSum / (double) buyPrice;
    }
}
