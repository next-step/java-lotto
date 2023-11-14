package lotto.view;

import lotto.domain.*;

import java.util.Map;

public class ResultView {
    private static final String BUYING_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String LINE = "---------";
    private static final String OPENING_PARENTHESIS = " (";
    private static final String CLOSING_PARENTHESIS = ")- ";
    private static final String QUANTITY = "개";
    private static final String REVENUE_TOTAL = "총 수익률은 ";
    private static final String THAT = "입니다.";
    private static final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String MANUAL = "수동으로 ";
    private static final String PAPER_QUANTITY = "장, ";
    private static final String AUTO = "자동으로 ";

    public void reportBuying(int autoLottoCount,
                             int manualLottoCount,
                             Lottos lottos) {
        System.out.println(MANUAL + manualLottoCount + PAPER_QUANTITY + AUTO + autoLottoCount + BUYING_QUANTITY);
        for (Lotto lotto : lottos.getAll()) {
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

    public void reportStats(WinningResults winningResults,
                            BuyingAmount buyingAmount) {
        System.out.println();
        System.out.println(WINNING_STATS);
        System.out.println(LINE);

        Map<LottoRank, Integer> winningResult = winningResults.getAll();
        for (Map.Entry<LottoRank, Integer> result : winningResult.entrySet()) {
            LottoRank lottoRank = result.getKey();
            printReport(result, lottoRank);
        }

        RevenueRate revenueRate = winningResults.revenue(buyingAmount);
        System.out.print(REVENUE_TOTAL + revenueRate.toString() + THAT);
        if (!revenueRate.isBenefit()) {
            System.out.println(LOSS);
        }

    }

    private static void printReport(Map.Entry<LottoRank, Integer> result,
                                    LottoRank lottoRank) {
        if (lottoRank.isWin()) {
            System.out.println(lottoRank.description() + OPENING_PARENTHESIS + lottoRank.prizeToString() + CLOSING_PARENTHESIS + result.getValue() +
                    QUANTITY);
        }
    }

}
