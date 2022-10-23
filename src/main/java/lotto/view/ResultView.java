package lotto.view;

import lotto.core.Lottos;
import lotto.core.WinnerCount;

public class ResultView {

    public static final String RESULT_BANNER = "당첨 통계\n---------";
    public static final String LOTTOS_PRINT_FORMAT = "%d개 일치 (%d원)- %d개";
    public static final String RATIO_PRINT_FORMAT = "총 수익률은 %.2f입니다.";

    public void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(System.out::println);
    }

    public void printResult(WinnerCount winnerCount, double profitRatio){
        System.out.println(RESULT_BANNER);
        winnerCount.getWinnerCount().forEach((winnerRank, integer) -> {
            System.out.printf(LOTTOS_PRINT_FORMAT, winnerRank.getCorrectNumberCount(), winnerRank.getAward(), integer);
            System.out.println();
        });
        System.out.printf(RATIO_PRINT_FORMAT, profitRatio);
    }
}
