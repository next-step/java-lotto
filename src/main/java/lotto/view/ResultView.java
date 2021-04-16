package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

public class ResultView {
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String RESULT_DELIMITER = "---------";
    private static final String BALL_DELIMITER = ", ";
    private static final String PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchase(Lottos lottos) {
        System.out.println(lottos.size() + PURCHASE_MESSAGE);
        for (Lotto lotto : lottos.getLottos()) {
            printLottoNumbers(lotto.getLottoBalls());
        }
        System.out.println();
    }

    public static void printLottoNumbers(LottoBalls lottoBalls) {
        System.out.println(lottoBalls.getSortedLottoBalls().stream()
        .map(LottoBall::toStringValue)
        .collect(Collectors.joining(BALL_DELIMITER, "[", "]")));
    }

    public static void printWinningResult(LottoResult result) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        System.out.println(RESULT_DELIMITER);
        printPrizeResult(result, Prize.THREE);
        printPrizeResult(result, Prize.FOUR);
        printPrizeResult(result, Prize.FIVE);
        printPrizeResult(result, Prize.SIX);
    }

    public static void printEarningRate(Money payment, LottoResult result) {
        BigDecimal price = BigDecimal.valueOf(payment.getMoney());
        BigDecimal earningRate = (result.profit()).divide(price, 2, RoundingMode.HALF_EVEN);
        System.out.printf("총 수익률은 %.2f입니다.", earningRate);
        if (earningRate.intValue() < 1) {
            System.out.println(PROFIT_MESSAGE);
        }
    }

    private static void printPrizeResult(LottoResult result, Prize prize) {
        System.out.println(prize.getMessage() + " - " + result.counts(prize) + "개");
    }
}
