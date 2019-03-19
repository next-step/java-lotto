package lotto.view;

import lotto.Lotto;
import lotto.Prize;
import lotto.PurchaseHistory;
import lotto.StatisticsResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String DIVISION_LINE = "---------";
    private static final String NUMBER_OF_LOTTO_MENT = "를 구매했습니다.";
    private static final String WINNING_STATISTICS_INTRODUCTION_MENT = "당첨 통계";
    private static final String NUMBER_UNIT_MENT = "개";
    private static final String RATE_OF_RETURN_FIRST_MENT = "총 수익률은 ";
    private static final String RATE_OF_RETURN_SECOND_MENT = "입니다.";

    private static StringBuilder purchaseResultString = new StringBuilder();
    private static StringBuilder winningStatisticsString = new StringBuilder();

    public static void printPurchaseResult(PurchaseHistory purchase) {
        producePurchaseHistoryResult(purchase.getLottos());
        System.out.println(purchaseResultString);
    }

    private static void producePurchaseHistoryResult(List<Lotto> lottos) {
        purchaseResultString.append(lottos.size())
                .append(NUMBER_UNIT_MENT)
                .append(NUMBER_OF_LOTTO_MENT)
                .append(NEW_LINE);
        lottos.stream().forEach(e -> purchaseResultString.append(e.toString()).append(NEW_LINE));
    }

    public static void printStatisticsResult(StatisticsResult statisticsResult) {
        producePrizeCountResult(statisticsResult.getPrizeCount());
        produceRateOfReturnResult(statisticsResult.getRateOfReturn());
        System.out.println(winningStatisticsString);
    }

    private static void producePrizeCountResult(Map<Prize, Integer> prizeCount) {
        winningStatisticsString.append(WINNING_STATISTICS_INTRODUCTION_MENT)
                .append(NEW_LINE)
                .append(DIVISION_LINE)
                .append(NEW_LINE);
        Stream.of(Prize.values())
                .forEach(e -> {
                    if (e != Prize.NO_PRIZE) {
                        winningStatisticsString.append(e.toString())
                                .append(prizeCount.getOrDefault(e, 0))
                                .append(NUMBER_UNIT_MENT)
                                .append(NEW_LINE);
                    }
                });
    }

    private static void produceRateOfReturnResult(double rateOfReturn) {
        winningStatisticsString.append(RATE_OF_RETURN_FIRST_MENT)
                .append(rateOfReturn)
                .append(RATE_OF_RETURN_SECOND_MENT);
    }

}


