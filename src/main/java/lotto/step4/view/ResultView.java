package lotto.step4.view;

import lotto.step4.domain.*;

public class ResultView {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_BREAK = "---------";

    public static void printLottoInfo(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, autoCount);

    }

    public static void printLottoNumbers(Lotteries lotteries) {
        for (Lottery lottery : lotteries.getLotteries()) {
            System.out.println(lottery);
        }
        System.out.println();
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_BREAK);

        for (Rank rank : Rank.values()) {
            printRank(rank, lottoStatistics);
        }
    }

    private static void printRank(Rank rank, LottoStatistics lottoStatistics) {
        if (rank.equals(Rank.NONE)) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(), lottoStatistics.getLottoStatistics().getOrDefault(rank, 0));
            return;
        }
        System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getCountOfMatch(), rank.getWinningMoney(), lottoStatistics.getLottoStatistics().getOrDefault(rank, 0));
    }

    public static void printEarningRate(double earningRate) {
        System.out.printf("총 수익률은 " + earningRate + "입니다.");
    }
}
