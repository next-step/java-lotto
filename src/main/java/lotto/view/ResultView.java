package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {

    private ResultView() {}

    private static final String PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String RESULT_DELIMITER = "---------";
    private static final String BALL_DELIMITER = ", ";
    private static final String PROFIT_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printPurchase(Lottos lottos, int inputManualCounts) {
        System.out.printf(PURCHASE_MESSAGE, inputManualCounts, lottos.size() - inputManualCounts);
        System.out.println();
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
        System.out.println(prizeResult(result));
    }

    public static void printEarningRate(Money money, LottoResult result) {
        BigDecimal earningRate = result.earningRate(BigDecimal.valueOf(money.getPayment()));
        System.out.printf("총 수익률은 %.2f입니다.", earningRate);
        if (earningRate.intValue() < 1) {
            System.out.println(PROFIT_MESSAGE);
        }
    }

    private static String prizeResult(LottoResult result) {
        return Arrays.stream(Prize.values())
                .map(prize -> printString(prize, result.counts(prize)))
                .reduce("", String::concat);
    }

    private static String printString(Prize prize, long count) {
        String format = "%s- %d개\n";
        return String.format(format, prize.getMessage(), count);
    }
}
