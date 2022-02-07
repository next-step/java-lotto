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

    public void printAnalyzeResults(double profitPercent) {
        System.out.println("당첨통계");
        System.out.println("---------");
        printPrizeMoney(Ranking.FIRST);
        printPrizeMoney(Ranking.SECOND);
        printPrizeMoney(Ranking.THIRD);
        printPrizeMoney(Ranking.FOURTH);
        printPrizeMoney(Ranking.FIFTH);
        printProfitPercent(profitPercent);
    }

    public void printPrizeMoney(Ranking ranking) {
        StringBuilder sb = new StringBuilder("%d개 일치");
        if (ranking.getBonus() == 1) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append("(%d원) - %d개%n");
        System.out.printf((sb.toString()), ranking.getNumberOfMatches(), ranking.getPrizeMoney(),
            ranking.getCount());
    }


    public void printProfitPercent(double profitPercent) {
        System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitPercent);
    }
}
