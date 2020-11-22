package lotto_auto.view;

import lotto_auto.model.LottoResult;
import lotto_auto.model.LottoStatistic;

public class StatisticResultView {

    private static final String STATISTIC_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String STRING_DIVIDER = "---------";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String BENEFIT_MESSAGE = "기준이 1이기 때문에 결과적으로 이득이라는 의미임";
    private static final String LOSE_MESSAGE = "기준이 1이기 때문에 결과적으로 손해이라는 의미임";

    public static void printStatistic(LottoStatistic lottoStatistic) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STATISTIC_MESSAGE);
        sb.append(System.lineSeparator());
        sb.append(STRING_DIVIDER);
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(lottoStatistic, 4));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(lottoStatistic, 3));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(lottoStatistic, 2));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(lottoStatistic, 1));
        sb.append(System.lineSeparator());
        sb.append(buildYieldDetailMessage(lottoStatistic));
        sb.append(System.lineSeparator());
        System.out.println(sb);
    }

    private static String buildStatisticMessage(LottoStatistic lottoStatistic, int rank) {
        LottoResult lottoResult = LottoResult.valueOfRank(rank);
        return String.format(STATISTIC_MESSAGE, lottoResult.getMatchNum(), lottoResult.getMoney(), lottoStatistic.getRankLottoCount(rank));
    }

    private static String buildYieldDetailMessage(LottoStatistic lottoStatistic) {
        double yield = lottoStatistic.getYield();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(TOTAL_YIELD_MESSAGE, yield));
        sb.append(yield < 1 ? LOSE_MESSAGE : BENEFIT_MESSAGE);
        return sb.toString();
    }

}
