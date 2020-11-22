package lotto_auto.view;

import lotto_auto.model.LottoResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticResultView {

    private static final String STATISTIC_MESSAGE = "%s개 일치 (%s원)- %s개";
    private static final String STRING_DIVIDER = "---------";
    private static final String WINNING_STATISTIC_MESSAGE = "당첨 통계";
    private static final String TOTAL_YIELD_MESSAGE = "총 수익률은 %.2f 입니다.";
    private static final String BENEFIT_MESSAGE = "기준이 1이기 때문에 결과적으로 이득이라는 의미임";
    private static final String LOSE_MESSAGE = "기준이 1이기 때문에 결과적으로 손해이라는 의미임";

    public static void printStatistic(List<LottoResult> statistic, int money) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_STATISTIC_MESSAGE);
        sb.append(System.lineSeparator());
        sb.append(STRING_DIVIDER);
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(statistic, 3));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(statistic, 4));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(statistic, 5));
        sb.append(System.lineSeparator());
        sb.append(buildStatisticMessage(statistic, 6));
        sb.append(System.lineSeparator());
        sb.append(buildYieldDetailMessage(statistic, money));
        sb.append(System.lineSeparator());
        System.out.println(sb);
    }

    private static String buildStatisticMessage(List<LottoResult> statistic, int rank) {
        List<LottoResult> collect = statistic.stream()
                .filter(item -> item.getRank() == rank)
                .collect(Collectors.toList());
        LottoResult lottoResult = LottoResult.valueOfRank(rank);
        return String.format(STATISTIC_MESSAGE, lottoResult.getMatchNum(), lottoResult.getMoney(), collect.size());
    }

    private static double computeYield(List<LottoResult> statistic, double money) {
        long sum = statistic.stream()
                .filter(LottoResult::isWinning)
                .mapToLong(LottoResult::getMoney)
                .sum();
        return (double) sum / money;
    }

    private static String buildYieldDetailMessage(List<LottoResult> statistic, double money) {
        double yield = computeYield(statistic, money);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(TOTAL_YIELD_MESSAGE, yield));
        sb.append(yield < 1 ? BENEFIT_MESSAGE : LOSE_MESSAGE);
        return sb.toString();

    }

}
