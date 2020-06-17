package view;

import lotto.LottoTicket;
import lotto.Prize;

import java.util.List;

public class ResultView {
    public static void printNumberOfLottoTicek(int cnt) {
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public static void printTickets(List<LottoTicket> tickets) {
        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.makeTicketForPrint());
        }
    }

    public static void printStatistics(List<Integer> matcher, double percentage) {
        System.out.println("당첨 통계");
        for (int i = Prize.FORTH.getCnt(); i < Prize.FIRST.getCnt() + 1; i++) {
            System.out.println(i + "개 일치 (" + Prize.matchPrize(i) + ")- " + matcher.get(i) + "개");
        }
        System.out.println("총 수익률은 " + percentage + "입니다.");
    }
}
