package lotto.view;

import lotto.Lotto;
import lotto.Prize;
import lotto.PurchaseHistory;
import lotto.StatisticsResult;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {
    private static final String DIVISION_LINE = "---------";
    private static final String NUMBER_OF_LOTTO_MENT = "를 구매했습니다.";
    private static final String WINNING_STATISTICS_INTRODUCTION_MENT = "당첨 통계";
    private static final String NUMBER_UNIT_MENT = "개";
    private static final String RATE_OF_RETURN_FIRST_MENT = "총 수익률은 ";
    private static final String RATE_OF_RETURN_SECOND_MENT = "입니다.";

    public static void printPurchaseResult(PurchaseHistory purchase) {
        producePurchaseHistoryResult(purchase.getLottos());
    }

    private static void producePurchaseHistoryResult(List<Lotto> lottos) {
        System.out.print(lottos.size());
        System.out.print(NUMBER_UNIT_MENT);
        System.out.println(NUMBER_OF_LOTTO_MENT);

        lottos.stream().forEach(System.out::println);
    }

    public static void printStatisticsResult(StatisticsResult statisticsResult) {
        System.out.println(WINNING_STATISTICS_INTRODUCTION_MENT);
        System.out.println(DIVISION_LINE);
        producePrizeCountResult(statisticsResult.getPrizeCount());
        produceRateOfReturnResult(statisticsResult.getRateOfReturn());
    }

    private static void producePrizeCountResult(Map<Prize, Integer> prizeCount) {
        Stream.of(Prize.values())
                .forEach(e -> {
                    if (e != Prize.NO_PRIZE) {
                        System.out.print(e);
                        System.out.print(prizeCount.getOrDefault(e, 0));
                        System.out.println(NUMBER_UNIT_MENT);
                    }
                });
    }

    private static void produceRateOfReturnResult(double rateOfReturn) {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print(RATE_OF_RETURN_FIRST_MENT);
        System.out.print(df.format(rateOfReturn));
        System.out.println(RATE_OF_RETURN_SECOND_MENT);
    }

}


