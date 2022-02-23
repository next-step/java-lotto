package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.domain.Ranking;
import lotto.domain.Rankings;
import lotto.domain.Reward;

public class LottoOutput {

    private static final String ENTER = "\n";
    private static final String BUYSUM_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    private static final String RANKING_STATUS_MESSAGE = "당첨 통계" + ENTER;
    private static final String RANKING_DELIMITER = "-----------" + ENTER;
    private static final String REWARD_RATE_MESSAGE = "총 수익률은 : %s입니다.";
    private static final String DASH = " - ";
    private static final String PIECE = "개";
    private static final String LOTTO_NUM_SUM_MESSAGE = "%s개 일치%s(%s원)";
    private static final String BONUS_MESSAGE = ",보너스 볼 일치";
    private static final List<Ranking> ORDER_PRINT_RANKING = new ArrayList<>(
        Arrays.asList(Ranking.FIVE, Ranking.FOUR, Ranking.THREE, Ranking.TWO,
            Ranking.ONE));

    private LottoOutput() {
    }

    public static void printBuySum(int autoBuyCount, int manulBuyCount) {
        String sumStatus = String.format(BUYSUM_MESSAGE, manulBuyCount, autoBuyCount);
        System.out.println(sumStatus);
    }

    public static void printLottoResult(Rankings rankings, Price buyPrice) {
        StringBuilder rankingStatus = printRankingStatus(rankings);
        String rewardRate = printRewardRate(new Reward(rankings, buyPrice));
        System.out.println(rankingStatus
            .append(ENTER)
            .append(rewardRate));
    }

    private static StringBuilder printRankingStatus(Rankings rankings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RANKING_STATUS_MESSAGE);
        stringBuilder.append(RANKING_DELIMITER);

        for (Ranking ranking : ORDER_PRINT_RANKING) {
            stringBuilder
                .append(convertRankingToStatus(ranking))
                .append(DASH)
                .append(rankings.countFrequency(ranking))
                .append(PIECE)
                .append(ENTER);
        }

        return stringBuilder;
    }

    private static String convertRankingToStatus(Ranking ranking) {
        int matchNum = ranking.getNormalMatcNumber();
        String bonusMessage = "";
        if (ranking.getBonusMatch()) {
            matchNum++;
            bonusMessage = BONUS_MESSAGE;
        }
        return String.format(LOTTO_NUM_SUM_MESSAGE, matchNum, bonusMessage,
            ranking.getWinnerPrice());
    }

    private static String printRewardRate(Reward reward) {
        return String.format(REWARD_RATE_MESSAGE, reward.getValue());
    }

    public static void printLottoNumber(Lottos lottoNumbers) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Lotto lotto : lottoNumbers.getValues()) {
            stringBuilder
                .append(Arrays.toString(lotto.getLottoNumbers().toArray()))
                .append(ENTER);
        }

        System.out.println(stringBuilder);
    }
}
