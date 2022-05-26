package step2.view;

import step2.domain.Lotto;
import step2.domain.Statistics;

public class ResultView {
    public static int countOfTickets(int purchase) {

        int cnt = purchase/1000;
        System.out.println(String.format("%d개를 구매했습니다.", cnt));
        return cnt;
    }

    public static void printTickets(Lotto lotto) {
        lotto.print();
        System.out.println();
    }

    public static void printStatistics(Statistics statistics, int purchase) {


        System.out.println("당첨 통계");
        System.out.println("-------");

        System.out.println(statistics.getMatchInfos());

        System.out.println(statistics.getRateOfReturn(purchase));
    }
}
