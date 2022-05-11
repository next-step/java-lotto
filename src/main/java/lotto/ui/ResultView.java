package lotto.ui;

import lotto.domain.LottoGame;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Rank;

import java.text.DecimalFormat;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매했습니다.";
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

    public static void printBuyLottoNumbers(LottoGame lotto) {
        for(Lotto lottoNumbers : lotto.getBuyLottoNumbers()) {
            System.out.println(lottoNumbers.toString());
        }
    }

    public static void printWinningTitle() {
        System.out.println(WINNER_TITLE);
        System.out.println(PERFORATION);
    }

    public static void printBuyQuantityMessage(int qty) {
        System.out.println(qty + BUY_QUANTITY_MESSAGE);
    }

    public static void printWinningResults(LottoResults results) {
        for (Rank rank : Rank.values()) {
            printWinningResult(results, rank);
        }
    }

    private static void printWinningResult(LottoResults results, Rank rank) {
        String message = "";
        if (rank == Rank.SECOND) {
            message = BONUS_MATCH_MESSAGE;
        }
        System.out.printf(WINNING_RESULT, rank.getCountOfMatch(), message,
                new DecimalFormat("###,###").format(rank.getWinningMoney()), results.getWinningCount(rank));
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
