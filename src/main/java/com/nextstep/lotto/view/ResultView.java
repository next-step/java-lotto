package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoStatistics;
import com.nextstep.lotto.domain.LottoWinning;
import com.nextstep.lotto.domain.Lottos;

public class ResultView {

    public static void printStatistics(LottoStatistics lottoStatistics) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        printWinnings(lottoStatistics);
        printProfitRate(lottoStatistics);
    }

    private static void printProfitRate(LottoStatistics lottoStatistics) {
        double profitRate = lottoStatistics.profitRate();
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

    private static void printWinnings(LottoStatistics lottoStatistics) {
        for (LottoWinning lottoWinning : LottoWinning.values()) {
            printWinning(lottoWinning, lottoStatistics.getCount(lottoWinning));
        }
    }

    private static void printWinning(LottoWinning lottoWinning, int count) {
        if (LottoWinning.RETIRE != lottoWinning) {
            System.out.printf(getPrintWinningFormat(lottoWinning), lottoWinning.getMatchedCount(), lottoWinning.getWinningPrice(), count);
            System.out.println();
        }
    }

    private static String getPrintWinningFormat(LottoWinning lottoWinning) {
        if (lottoWinning == LottoWinning.WIN_2ND) {
            return "%s개 일치, 보너스 볼 일치(%s원)- %s개";
        }
        return "%s개 일치 (%s원)- %s개";
    }

    public static void printBuy(Lottos lottos) {
        System.out.println(lottos.count() + "개를 구매했습니다.");
        System.out.println(lottos.toString());
        System.out.println();
    }
}