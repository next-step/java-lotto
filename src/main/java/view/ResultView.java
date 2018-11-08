package view;

import domain.GameResult;
import domain.Ticket;

import java.util.List;

public class ResultView {

    public static void printLottoTicketCount(int num) {
        System.out.println(num + "개를 구매했습니다.");
    }

    public static void printTickets(List<Ticket> tickets) {
        tickets.forEach(ticket -> System.out.println("[" + ticket.toString() + "]"));
        System.out.println();
    }

    public static void printLottoResults(GameResult gameResult) {
        System.out.println("3개 일치 (5000원)- " + gameResult.getLottoResults().get(3));
        System.out.println("4개 일치 (50000원)- " + gameResult.getLottoResults().get(4));
        System.out.println("5개 일치 (1500000원)- "+ gameResult.getLottoResults().get(5));
        System.out.println("6개 일치 (2000000000원)- " + gameResult.getLottoResults().get(6));
        System.out.println("총 수익률은 "+ gameResult.calculateBenefitRate() +"입니다."); // 당첨금액의 합계 / 로또 구입 금액
    }
}
