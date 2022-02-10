package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoNumbers;
import lotto.domain.Ranking;
import lotto.service.RewardRateCalculator;

public class LottoOutput {

    private static final String ENTER = "\n";
    private static final String BUYSUM_MESSAGE = "개를 구매했습니다.";
    private static final String RANKING_STATUS_MESSAGE = "당첨 통계" + ENTER;
    private static final String RANKING_DELIMITER = "-----------" + ENTER;
    private static final String REWARD_RATE_MESSAGE = "총 수익률은 ";
    private static final String DASH = " - ";
    private static final String PIECE = "개";
    private static final List<Ranking> ORDER_PRINT_RANKING = new ArrayList<>(
        Arrays.asList(Ranking.FIVE, Ranking.FOUR, Ranking.FOUR, Ranking.THREE, Ranking.TWO,
            Ranking.ONE));

    private LottoOutput() {
    }

    public static void printBuySum(int buyNum) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buyNum)
            .append(BUYSUM_MESSAGE);
        System.out.println(stringBuilder);
    }

    public static void printRankingStatus(List<Ranking> rankings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RANKING_STATUS_MESSAGE);
        stringBuilder.append(RANKING_DELIMITER);

        Map<Ranking, Integer> rankingCount = countRanking(rankings);
        for (Ranking ranking : ORDER_PRINT_RANKING) {
            stringBuilder.append(ranking).append(DASH)
                .append(rankingCount.getOrDefault(ranking, 0)).append(PIECE).append(ENTER);
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
        stringBuilder.append(REWARD_RATE_MESSAGE);
        int winnerPriceSum = countWinnerPriceSum(rankings);
        double rewardRate = RewardRateCalculator.countRewardRate(winnerPriceSum, buyPrice);
        stringBuilder.append(rewardRate);
        System.out.println(stringBuilder);
    }

    private static int countWinnerPriceSum(List<Ranking> rankings) {
        return rankings.stream()
            .map(Ranking::getWinnerPrice)
            .reduce(0, Integer::sum);
    }

    public static void printLottoNumber(List<LottoNumbers> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (LottoNumbers lottoNumber : lottoNumbers) {
            stringBuilder.append(Arrays.toString(lottoNumber.getNumbers().toArray())).append(ENTER);
        }

        System.out.println(stringBuilder);
    }
}
