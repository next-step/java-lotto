package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.%n";
    private static final String SAME = "본전";
    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String WINNER_TITLE = "당첨 통계";
    private static final String PERFORATION = "-------";
    private static final String WINNING_RESULT = "%d개 일치%s (%s원)- %d개%n";
    private static final String RETURN_RATE = "총 수익률은 %s입니다.";
    private static final String RETURN_RATE_RESULT = "(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";
    private static final String FLOOR = "%.2f";
    private static final String BONUS_MATCH_MESSAGE = ", 보너스 볼 일치";
    private static final String NUMBER_FORMAT = "###,###";

    public static void printBuyLottoNumbers(List<Lotto> lottoNumbers) {
        for(Lotto lotto : lottoNumbers) {
            System.out.println(lotto.toString());
        }
    }

    public static void printBuyQuantityMessage(double manualQuantity, double autoQuantity) {
        System.out.printf(BUY_QUANTITY_MESSAGE, manualQuantity, autoQuantity);
    }

    public static void printWinningTitleAndResults(LottoResults results) {
        printWinningTitle();
        printWinningResults(results);
    }

    private static void printWinningTitle() {
        System.out.println(WINNER_TITLE);
        System.out.println(PERFORATION);
    }

    private static void printWinningResults(LottoResults results) {
        for (Rank rank : Rank.values()) {
            printWinningResult(results, rank);
        }
    }

    private static void printWinningResult(LottoResults results, Rank rank) {
        System.out.printf(WINNING_RESULT,
                rank.getCountOfMatch(), getBonusMatchMessage(rank), toDecimal(rank), results.getWinningCount(rank));
    }

    private static String getBonusMatchMessage(Rank rank) {
        if (isSecond(rank)) {
            return BONUS_MATCH_MESSAGE;
        }
        return "";
    }

    private static boolean isSecond(Rank rank) {
        return rank == Rank.SECOND;
    }

    private static String toDecimal(Rank rank) {
        return new DecimalFormat(NUMBER_FORMAT).format(Double.parseDouble(rank.getWinningMoney().toString()));
    }

    public static void printReturnRate(double returnRate) {
        System.out.printf(RETURN_RATE, getFloorValue(returnRate));
        System.out.printf(RETURN_RATE_RESULT, getReturnRate(returnRate));
    }

    private static String getFloorValue(double returnRate) {
        return String.format(FLOOR, Math.floor(returnRate * 100) / 100.0);
    }

    private static String getReturnRate(double returnRate) {
        if (returnRate == 1) {
            return SAME;
        }
        if (returnRate > 1) {
            return PROFIT;
        }
        return LOSS;
    }
}
