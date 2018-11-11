package lotto.view;

import lotto.domain.GameResult;
import lotto.domain.Ticket;
import lotto.enums.MatchType;

import java.util.List;

public class ResultView {

    public static void printLottoTicketCount(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printTickets(List<Ticket> tickets) {
        tickets.forEach(ticket -> System.out.println("[" + ticket.toString() + "]"));
        System.out.println();
    }

    public static void printLottoResults(GameResult result) {
        System.out.println("3개 일치 (5000원)- " + result.getLottoResults().get(MatchType.THREE.getMatch()));
        System.out.println("4개 일치 (50000원)- " + result.getLottoResults().get(MatchType.FOUR.getMatch()));
        System.out.println("5개 일치 (1500000원)- " + result.getLottoResults().get(MatchType.FIVE.getMatch()));
        System.out.println("6개 일치 (2000000000원)- " + result.getLottoResults().get(MatchType.SIX.getMatch()));
        System.out.println("총 수익률은 " + result.getBenefitRate() + "입니다.");
    }
}
