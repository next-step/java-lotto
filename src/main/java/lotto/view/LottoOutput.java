package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;

public class LottoOutput {

    private LottoOutput() {
    }

    public static void printBuySum(int buyNum) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buyNum)
            .append("개를 구매했습니다.");
        System.out.println(stringBuilder);
    }

    public static void printRankingStatus(List<Ranking> rankings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계 \n");
        stringBuilder.append("----------- \n");

        List<Ranking> showRankings = new ArrayList<>(Arrays.asList(Ranking.FIVE, Ranking.FOUR, Ranking.FOUR, Ranking.THREE, Ranking.TWO, Ranking.ONE));
        Map<Ranking, Integer> rankingCount = countRanking(rankings);
        for(Ranking ranking : showRankings){
            stringBuilder.append(ranking).append(" - ")
                .append(rankingCount.getOrDefault(ranking, 0)).append("개").append("\n");
        }

        System.out.println(stringBuilder);
    }

    private static Map<Ranking, Integer> countRanking(List<Ranking> rankings) {
        Map<Ranking, Integer> successSum = new EnumMap<>(Ranking.class);
        for (Ranking ranking : rankings) {
            successSum.put(ranking, successSum.getOrDefault(ranking, 0) + 1);
        }
        return successSum;
    }

    public static void printRewardRate(List<Ranking> rankings, int buyPrice) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ");
        int winnerPriceSum = countWinnerPriceSum(rankings);
        double rewardRate = countRewardRate(winnerPriceSum, buyPrice);
        stringBuilder.append(rewardRate);
        System.out.println(stringBuilder);
    }

    private static int countWinnerPriceSum(List<Ranking> rankings) {
        return rankings.stream()
            .map(Ranking::getWinnerPrice)
            .reduce(0, Integer::sum);
    }

    private static double countRewardRate(int winnerPriceSum, int buyPrice) {
        return Math.round(winnerPriceSum / (double) buyPrice);
    }

    public static void printLottoNumber(List<LottoNumbers> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumbers lottoNumber : lottoNumbers) {
            stringBuilder.append(Arrays.toString(lottoNumber.getNumbers().toArray())).append("\n");
        }

        System.out.println(stringBuilder);
    }
}
