package view;

import lotto.*;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }

    public static void printSummary(Map<PrizeRank, Integer> summary) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (PrizeRank prize : summary.keySet()) {
            System.out.printf("%s - %d개\n", prize.toString(), summary.get(prize));
        }

        float profit = ProfitCalculator.calculate(summary);
        System.out.print("총 수익률은 " + profit + "입니다.");
        if (profit < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }
}