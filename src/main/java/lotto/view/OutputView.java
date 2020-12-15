package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.MatchCount;
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
        String additionalMessage =
              profit.compareTo(new BigDecimal(1)) < 0 ? " (기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        System.out.printf("총 수익률은 %.2f입니다." + additionalMessage, profit.doubleValue());
    }

    private static void printMatchCounts(Map<MatchCount, Integer> matchCounts) {
        List<MatchCount> matchCountKeys = new ArrayList<>(matchCounts.keySet());
        matchCountKeys.sort(OutputView::compare);

        matchCountKeys
              .forEach(matchCount -> printMatchCount(matchCount, matchCounts.get(matchCount)));
    }

    private static void printMatchCount(MatchCount matchCount, int ticketCount) {
        System.out.println(matchCount.printMessage(ticketCount));
    }

    private static int compare(MatchCount m1, MatchCount m2) {
        if (m1.getMatchCount() > m2.getMatchCount()) {
            return 1;
        }

        if (m1.getMatchCount() == m2.getMatchCount()) {
            return 0;
        }

        return -1;
    }
}
