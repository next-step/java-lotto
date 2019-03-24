package lotto.view;

import lotto.LottosResult;
import lotto.Prize;
import lotto.PurchasedLottos;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Map;
import java.util.stream.Stream;

public class OutputView {
    private static final String DIVISION_LINE = "---------";
    private static final String WINNING_STATISTICS_INTRODUCTION_MENT = "당첨 통계";
    private static final String NUMBER_UNIT_MENT = "개";
    private static final String RATE_OF_RETURN_FIRST_MENT = "총 수익률은 ";
    private static final String RATE_OF_RETURN_SECOND_MENT = "입니다.";

    public static void printPurchaseResult(PurchasedLottos purchase) {
        producePurchaseHistoryResult(purchase);
    }

    private static void producePurchaseHistoryResult(PurchasedLottos purchase) {
        String purchaseResult = "수동으로 {0}개, 자동으로 {1}개를 구매했습니다.";
        System.out.println(MessageFormat.format(purchaseResult, purchase.getNumberOfManualLotto(), purchase.getLottos().size() - purchase.getNumberOfManualLotto()));
        purchase.getLottos().forEach(System.out::println);
    }

    public static void printStatisticsResult(LottosResult lottosResult) {
        System.out.println(WINNING_STATISTICS_INTRODUCTION_MENT);
        System.out.println(DIVISION_LINE);
        producePrizeCountResult(lottosResult.getPrizeCount());
        produceRateOfReturnResult(lottosResult.getRateOfReturn());
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


