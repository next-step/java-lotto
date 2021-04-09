package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

public class ResultView {
    public void displayLotto(Lotto lotto) {
        System.out.println(lotto.displayLottoNumber());
    }

    public void displayLottoCount(int lottoCount) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
    }

    public void displayWinningStatistics(Rank rank, Integer winningCount) {
        if(rank == Rank.MISS){
            return ;
        }
        System.out.println(String.format("%d 개 일치(%d원)- %d개", rank.getCountOfMatch(), rank.getWinningMoney(), winningCount));
    }

    public void displayProfits(double result) {
        System.out.println(String.format("총 수익률은 %.2f입니다.(기준이 1이기 떄문에 결과적으로 손해라는 의미임)", result));
    }

    public void displayStatisticsTitle() {
        System.out.println("당첨 통계");
        System.out.println("--------");
    }
}
