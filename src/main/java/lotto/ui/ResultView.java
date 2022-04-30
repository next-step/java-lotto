package lotto.ui;

import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoWinning;
import lotto.Rank;

public class ResultView {
    private static final String BUY_QUANTITY_MESSAGE = "개를 구매했습니다.";
    private static final String SAME = "본전";
    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";
    private static final String WINNER_TITLE = "당첨 통계";
    private static final String PERFORATION = "-------";
    private static final String WINNING_RESULT = "%d개 일치 (%d원)- %d개%n";
    private static final String RETURN_RATE = "총 수익률은 %s입니다.";
    private static final String RETURN_RATE_RESULT = "(기준이 1이기 때문에 결과적으로 %s(이)라는 의미임)";

    public static void printBuyLottoNumbers(Lotto lotto) {
        System.out.println(lotto);
    }

    public static void printWinningTitle() {
        System.out.println(WINNER_TITLE);
        System.out.println(PERFORATION);
    }

    public static void printBuyQuantityMessage(int qty) {
        System.out.println(qty + BUY_QUANTITY_MESSAGE);
    }

    public static void printWinningResultsAndReturnRate(LottoWinning lottoWinning) {
        printWinningResults(lottoWinning);
        printReturnRate(lottoWinning.getReturnRate());
    }

    private static void printWinningResults(LottoWinning lottoWinning) {
        for (Rank rank : Rank.values()) {
            System.out.printf(WINNING_RESULT, rank.getCountOfMatch(), rank.getWinningMoney(), lottoWinning.getWinningCount(rank));
        }
    }

    private static void printReturnRate(String returnRate) {
        System.out.printf(RETURN_RATE, returnRate);
        System.out.printf(RETURN_RATE_RESULT, getReturnRate(returnRate));
    }

    private static String getReturnRate(String returnRateString) {
        double returnRate = Double.parseDouble(returnRateString);
        if (returnRate == 1) {
            return SAME;
        }
        if (returnRate > 1) {
            return PROFIT;
        }
        return LOSS;
    }

}
