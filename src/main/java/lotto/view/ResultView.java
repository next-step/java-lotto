package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningPrice;

public class ResultView {
    public void printNumberOfLotto(int lottoCounts) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCounts);
    }

    public void printLottoTickets(List<Lotto> lottoTickets) {
        for (Lotto lotto: lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printAnalyzeResults(List<WinningPrice> winningPrices, double profitPercent) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printWinningMoney(winningPrices);
        printProfitPercent(profitPercent);
    }

    public void printWinningMoney(List<WinningPrice> winningPrices) {
        for (WinningPrice price: winningPrices) {
            System.out.println(price);
        }
    }

    public void printProfitPercent(double profitPercent) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitPercent);
    }
    /* 당첨 통계
    ---------
    3개 일치 (5000원)- 1개
    4개 일치 (50000원)- 0개
    5개 일치 (1500000원)- 0개
    5개 일치, 보너스 볼 일치(30000000원) - 0개
    6개 일치 (2000000000원)- 0개
    총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
    */
}
