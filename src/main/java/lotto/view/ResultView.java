package lotto.view;

import lotto.domain.*;

import java.util.HashMap;
import java.util.Map;

public class ResultView {
    private static double totalMoney;
    public static void lottoTicketView(LottoTicket lottoTicket) {
        for (Lotto lotto: lottoTicket.getLottoTicket()) {
            System.out.println(lotto.toString());
        }
    }
    public static void statisticsView(LottoStatistics lottoStatistics, int number) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (Rank key : lottoStatistics.getLottoStatistics().keySet()) {
            Integer value = lottoStatistics.getLottoStatistics().get(key);
            System.out.println(key.getMatchCount() + "개 일치 " + "(" + key.getMoney() + "원)- " + value + "개");
            totalMoney = totalMoney + key.getMoney() * value;
        }

        int investment = number * 1000;
        double profitRate = ((double) totalMoney - investment) / investment * 100;
        System.out.println("총 수익률은 " + profitRate +"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
