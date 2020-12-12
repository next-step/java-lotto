package lotto.view;

import java.math.BigDecimal;
import java.util.List;
import java.util.TreeMap;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.MatchResult;

public class OutputView {

    private OutputView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = lottoTickets.getLottoTickets();
        System.out.println(lottoTicketList.size() + "개를 구매했습니다.");

        for (LottoTicket lottoTicket : lottoTicketList) {
            System.out.println(lottoTicket);
        }
    }

    public static void printResults(MatchResult matchResult) {
        System.out.println("당첨 통계\n" + "---------");
        printMatchCounts(matchResult.getMatchCounts());
        printProfit(matchResult.calculateProfit());
    }

    private static void printProfit(BigDecimal profit) {
        String additionalMessage = profit.compareTo(new BigDecimal(1)) < 0 ? " (기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        System.out.printf("총 수익률은 %.2f입니다." + additionalMessage, profit.doubleValue());
    }

    private static void printMatchCounts(TreeMap<Integer, Integer> matchCounts) {
        matchCounts.keySet()
              .forEach(matchCount -> printMatchCount(matchCount, MatchResult.getMatchPrice(matchCount), matchCounts.get(matchCount)));
    }

    private static void printMatchCount(int matchCount, int matchPrice, int ticketCount) {
        System.out.println(matchCount + "개 일치 (" + matchPrice + "원) - " + ticketCount + "개");
    }
}
