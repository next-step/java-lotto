package lotto.step3.view;

import lotto.step3.domain.*;

public class ResultView {
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_BREAK = "---------";

    public static void printLottoInfo(int money, Lotteries lotteries) {
        System.out.println(money / Money.LOTTO_PRICE + "개를 구매했습니다.");
        for (Lottery lottery : lotteries.getLotteries()) {
            System.out.println(lottery);
        }
    }

    public static void printLottoStatistics(LottoStatistics lottoStatistics) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_BREAK);

        for (Rank rank : Rank.values()) {
            if (rank.equals(Rank.NONE)){
                continue;
            }
            if(rank.equals(Rank.SECOND)) {
                System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개%n",rank.getCountOfMatch(), rank.getWinningMoney(), lottoStatistics.getLottoStatistics().getOrDefault(rank,0));
                continue;
            }
            System.out.printf("%d개 일치 (%d원) - %d개%n",rank.getCountOfMatch(), rank.getWinningMoney(), lottoStatistics.getLottoStatistics().getOrDefault(rank,0));
        }
    }
}
