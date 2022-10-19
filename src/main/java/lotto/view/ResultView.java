package lotto.view;

import lotto.core.Lottos;
import lotto.core.WinnerCount;
import lotto.core.WinnerRank;

import java.util.List;

public class ResultView {

    public void printLottos(Lottos lottos) {
        lottos.getLottos()
                .forEach(System.out::println);
    }

    public void printResult(WinnerCount winnerCount, double profitRatio){
        System.out.println("당첨 통계\n---------");
        winnerCount.getWinnerCount().forEach((winnerRank, integer) -> {
            System.out.printf("%d개 일치 (%d원)- %d개", winnerRank.getCorrectNumberCount(), winnerRank.getAward(), integer);
            System.out.println();
        });
        System.out.printf("총 수익률은 %.2f입니다.", profitRatio);
    }
}
