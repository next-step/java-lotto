package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoStatistics;
import com.nextstep.lotto.domain.LottoRank;
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
        for (LottoRank lottoRank : LottoRank.values()) {
            printWinning(lottoRank, lottoStatistics.getCount(lottoRank));
        }
    }

    private static void printWinning(LottoRank lottoRank, int count) {
        if (LottoRank.RETIRE != lottoRank) {
            System.out.printf(getPrintWinningFormat(lottoRank), lottoRank.getMatchedCount(), lottoRank.getWinningPrice(), count);
            System.out.println();
        }
    }

    private static String getPrintWinningFormat(LottoRank lottoRank) {
        if (lottoRank == LottoRank.WIN_2ND) {
            return "%s개 일치, 보너스 볼 일치(%s원)- %s개";
        }
        return "%s개 일치 (%s원)- %s개";
    }

    public static void printBuy(int manualCount, int autoCount, Lottos lottos) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.", manualCount, autoCount);
        System.out.println();
        System.out.println(lottos.toString());
        System.out.println();
    }
}