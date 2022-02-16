package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Rankings;

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

    public static void printLottoResult(Rankings rankings, int buyPrice) {
        StringBuilder rankingStatus = printRankingStatus(rankings);
        StringBuilder rewardRate = printRewardRate(rankings, buyPrice);
        System.out.println(rankingStatus.append(ENTER).append(rewardRate));
    }

    private static StringBuilder printRankingStatus(Rankings rankings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RANKING_STATUS_MESSAGE);
        stringBuilder.append(RANKING_DELIMITER);

        for (Ranking ranking : ORDER_PRINT_RANKING) {
            stringBuilder.append(ranking).append(DASH)
                .append(rankings.countFrequency(ranking)).append(PIECE).append(ENTER);
        }

        return stringBuilder;
    }

    private static StringBuilder printRewardRate(Rankings rankings, int buyPrice) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(REWARD_RATE_MESSAGE);
        double rewardCount = rankings.countRewardRate(buyPrice);
        stringBuilder.append(rewardCount);
        return stringBuilder;
    }

    public static void printLottoNumber(List<Lotto> lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lottoNumber : lottoNumbers) {
            stringBuilder.append(Arrays.toString(lottoNumber.getNumbers().toArray())).append(ENTER);
        }

        System.out.println(stringBuilder);
    }
}
