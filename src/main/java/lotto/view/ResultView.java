package lotto.view;

import lotto.constant.LottoPrize;
import lotto.domain.prize.WinningReport;
import lotto.domain.sales.LottoBundle;

public class ResultView {

    private final static String BELOW_ONE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private final static String OVER_ONE = "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";

    public void show(LottoBundle lottoBundle) {
        for (int i = 0; i < lottoBundle.count(); i++) {
            System.out.println(lottoBundle.lotto(i));
        }
    }

    public void report(WinningReport winningReport) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------------");
        printPrizes(winningReport);
        printProfit(winningReport.winningRate());
    }

    private void printPrizes(WinningReport winningReport) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            System.out.println(lottoPrize.getMatch()
                    + "개 일치 (" + lottoPrize.getPrize() + "원)- "
                    + winningReport.winAmount(lottoPrize.getMatch()) + "개");
        }
    }

    private void printProfit(double winningRate) {
        System.out.println("총 수익률은 "
                + String.format("%.2f", winningRate)
                + "입니다."
                + profitComment(winningRate));
    }

    private String profitComment(double winningRate) {
        return (winningRate > 1.0) ? OVER_ONE : BELOW_ONE;
    }
}
