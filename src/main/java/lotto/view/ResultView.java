package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Ranking;

public class ResultView {

    public void printNumberOfLotto(int lottoCounts) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCounts);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printAnalyzeResults(List<Ranking> winningPrices, double profitPercent) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printWinningMoney(winningPrices);
        printProfitPercent(profitPercent);
    }

    public void printWinningMoney(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            System.out.println(ranking);
        }
    }

    public void printProfitPercent(double profitPercent) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitPercent);
    }
}
