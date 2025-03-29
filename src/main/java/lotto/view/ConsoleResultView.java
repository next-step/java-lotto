package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.PrizeRank;
import lotto.domain.SummaryReport;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsoleResultView implements ResultViewInterface {
    @Override
    public void printTickets(LottoTickets tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : tickets.getTickets()) {
            System.out.println(lottoTicket.toString());
        }
    }

    @Override
    public void printSummary(SummaryReport summary) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printResult(summary);
        printProfit(summary.getProfit());
    }

    private static void printResult(SummaryReport summary) {
        for (PrizeRank prize : Arrays.stream(PrizeRank.values()).filter(p -> p != PrizeRank.NONE).collect(Collectors.toList())) {
            String bonusText = getBonusText(prize);
            System.out.printf("%d개 일치%s (%s)- %d개\n", prize.getMatchCount(), bonusText, formatMoney(prize.getPrize()), summary.getTicketCount(prize));
        }
    }

    private static String getBonusText(PrizeRank prize) {
        if (prize == PrizeRank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private static String formatMoney(int amount) {
        return String.format("%,d원", amount);
    }

    private static void printProfit(float profit) {
        System.out.print("총 수익률은 " + formatProfit(profit) + "입니다.");
        if (profit < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private static String formatProfit(float profit) {
        return String.format("%.2f", profit);
    }

}