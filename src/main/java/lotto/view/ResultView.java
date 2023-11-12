package lotto.view;

import lotto.domain.*;

import java.util.List;
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

    public void reportBuying(int lottoCount,
                             int manualLottoCount,
                             List<Lotto> manualLottos,
                             List<Lotto> lottos) {
        System.out.println("수동으로 " + manualLottoCount + "장, 자동으로 " + lottoCount + BUYING_QUANTITY);
        for (Lotto manualLotto : manualLottos) {
            System.out.println(manualLotto.toString());
        }
        for (Lotto lotto : lottos) {
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
            if (lottoRank.isWin()) {
                System.out.println(lottoRank.description() + OPENING_PARENTHESIS + lottoRank.prizeToString() + CLOSING_PARENTHESIS + result.getValue() +
                        QUANTITY);
            }
        }

        RevenueRate revenueRate = winningResults.revenue(buyingAmount);
        System.out.print(REVENUE_TOTAL + revenueRate.toString() + THAT);
        if (!revenueRate.isBenefit()) {
            System.out.println(LOSS);
        }

    }

}
